package com.android.booklyapp.di

import com.android.booklyapp.BuildConfig
import com.android.booklyapp.data.ebook_api.EbookApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun getEbookApiService(): EbookApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.EBOOK_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(EbookApiService::class.java)
    }
}