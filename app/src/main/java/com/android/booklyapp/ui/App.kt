package com.android.booklyapp.ui

import android.app.Application
import android.content.Context
import com.android.booklyapp.di.AppComponent
import com.android.booklyapp.di.DaggerAppComponent

class App : Application() {
    private lateinit var _appComponent: AppComponent

    companion object {
        fun getAppComponent(context: Context): AppComponent {
            return (context.applicationContext as App)._appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()

        _appComponent = DaggerAppComponent.create()
    }
}