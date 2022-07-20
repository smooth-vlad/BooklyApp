package com.android.booklyapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.booklyapp.data.ebook_api.EbookApiService
import com.android.booklyapp.data.ebook_api.classes.BestSeller
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val api: EbookApiService) : ViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    var bestSellers = MutableLiveData<List<BestSeller>>()

    init {
        viewModelScope.launch {
            try {
                val response = api.getBestSellers()
                bestSellers.postValue(response)
                Log.d(TAG, "SUCCESS ${response.size}")
            } catch (throwable : Throwable) {
                Log.e(TAG, throwable.toString())
            }
        }
    }
}