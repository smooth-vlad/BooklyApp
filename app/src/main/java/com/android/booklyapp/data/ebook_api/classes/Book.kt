package com.android.booklyapp.data.ebook_api.classes

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("author") var author: String,
    @SerializedName("price") var price: Double,
    @SerializedName("image") var image: String,
    @SerializedName("rate") var rate: Rate,
) {
    data class Rate(
        @SerializedName("score") var score: Double,
        @SerializedName("amount") var amount: Int,
    )
}