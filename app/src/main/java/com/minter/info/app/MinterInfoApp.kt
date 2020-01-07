package com.minter.info.app

import android.app.Application
import com.minter.info.app.core.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MinterInfoApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MinterInfoApp)

            modules(
                listOf(
                    localModule()
                )
            )
        }
    }
}