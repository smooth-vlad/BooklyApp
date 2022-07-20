package com.android.booklyapp.data.ebook_api.classes

import com.google.gson.annotations.SerializedName

data class BookImage(
    @SerializedName("id") var id: Int,
    @SerializedName("image") var image: String,
)