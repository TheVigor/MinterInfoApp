package com.minter.info.app.core.base

import androidx.lifecycle.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

abstract class BaseViewModel<S, E> : ViewModel() {

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState

    private val _errorState = SingleLiveEvent<Throwable>()
    val errorState: LiveData<Throwable> = _errorState

    val contentState = MutableLiveData<Result<S,E>>()

    protected fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _loadingState.value = true
                block()
            } catch (error: Exception) {
                _errorState.value = error
            } finally {
                _loadingState.value = false
            }
        }
    }

    protected fun launchDataLoadWithoutProgressBar(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                block()
            } catch (error: Exception) {
                _errorState.value = error
            }
        }
    }



    fun init(
        owner: LifecycleOwner,
        loading: (Boolean) -> Unit,
        error: (Throwable) -> Unit,
        result: (Result<S,E>) -> Unit) {

        loadingState.observe(owner, Observer {
            loading(it)
        })

        errorState.observe(owner, Observer {
            error(it)
        })

        contentState.observe(owner, Observer {
            result(it)
        })
    }
}