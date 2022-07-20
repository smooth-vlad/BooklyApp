package com.android.booklyapp.data.ebook_api

import com.android.booklyapp.data.ebook_api.classes.BestSeller
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EbookApiService {
    @GET("best/")
    suspend fun getBestSellers(): List<BestSeller>
}