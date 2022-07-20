package com.android.booklyapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.booklyapp.data.ebook_api.EbookApiService
import com.android.booklyapp.data.ebook_api.classes.Book
import com.android.booklyapp.data.ebook_api.classes.BookImage
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val api: EbookApiService) : ViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    val bestSellers = MutableLiveData<List<Book>>()
    val carouselBooks = MutableLiveData<List<BookImage>>()

    init {
        viewModelScope.launch {
            try {
                val response = api.getBestSellers()
                bestSellers.postValue(response)
                Log.d(TAG, "best sellers: SUCCESS ${response.size}")
            } catch (throwable : Throwable) {
                Log.e(TAG, throwable.toString())
            }
        }

        viewModelScope.launch {
            try {
                val response = api.getCarouselBooks()
                carouselBooks.postValue(response)
                Log.d(TAG, "carousel: SUCCESS ${response.size}")
            } catch (throwable : Throwable) {
                Log.e(TAG, throwable.toString())
            }
        }
    }
}