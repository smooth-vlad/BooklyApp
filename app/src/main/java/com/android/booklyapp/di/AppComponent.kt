package com.android.booklyapp.di

import android.app.Activity
import com.android.booklyapp.data.ebook_api.EbookApiService
import com.android.booklyapp.ui.details.view.DetailsActivity
import com.android.booklyapp.ui.details.viewmodel.DetailsViewModel
import com.android.booklyapp.ui.main.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getEbookApiService(): EbookApiService
    // MainViewModel
    fun inject(activity: MainActivity)
    // DetailsViewModel
    fun inject(activity: DetailsActivity)
}