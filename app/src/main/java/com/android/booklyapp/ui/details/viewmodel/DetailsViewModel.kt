package com.android.booklyapp.ui.details.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.android.booklyapp.data.ebook_api.EbookApiService
import com.android.booklyapp.data.ebook_api.classes.Book
import com.android.booklyapp.data.ebook_api.classes.BookImage
import com.android.booklyapp.ui.main.viewmodel.MainViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @AssistedInject constructor(
    private val api: EbookApiService,
    @Assisted private val bookId: Int) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(bookId: Int): DetailsViewModel
    }

    companion object {
        const val TAG = "DetailsViewModel"

        fun providesFactory(
            assistedFactory: Factory,
            bookId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(bookId) as T
            }
        }
    }

    val book = MutableLiveData<Book>()
    val similar = MutableLiveData<List<BookImage>>()

    init {
        Log.d(TAG, bookId.toString())

        viewModelScope.launch {
            try {
                val response = api.getBestSellers().find { it.id == bookId }
                book.postValue(response)
                Log.d(TAG, "bestSellers: SUCCESS")
            } catch (throwable : Throwable) {
                Log.e(TAG, throwable.toString())
            }
        }

        viewModelScope.launch {
            try {
                val response = api.getSimilar()
                similar.postValue(response)
                Log.d(TAG, "Similar: SUCCESS")
            } catch (throwable : Throwable) {
                Log.e(TAG, throwable.toString())
            }
        }
    }
}