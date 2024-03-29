package com.example.pokedex

import android.app.Application
import com.example.pokedex.di.apiModule
import com.example.pokedex.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule,
                    apiModule,
                )
            )
        }
    }
}