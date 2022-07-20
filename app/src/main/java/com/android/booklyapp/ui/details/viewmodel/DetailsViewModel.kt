package com.android.booklyapp.ui.details.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.android.booklyapp.data.ebook_api.EbookApiService
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
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

    init {
        Log.d(TAG, bookId.toString())
    }
}