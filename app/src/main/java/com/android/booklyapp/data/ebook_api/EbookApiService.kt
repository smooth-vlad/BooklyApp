package com.android.booklyapp.data.ebook_api

import com.android.booklyapp.data.ebook_api.classes.Book
import com.android.booklyapp.data.ebook_api.classes.BookImage
import retrofit2.http.GET

interface EbookApiService {
    @GET("best/")
    suspend fun getBestSellers(): List<Book>

    @GET("similar/")
    suspend fun getSimilar(): List<BookImage>
}