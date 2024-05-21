package com.deved.blogapp

import android.app.Application
import com.deved.blogapp.di.networkModule
import com.deved.blogapp.di.repositoryModule
import com.deved.blogapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }

}