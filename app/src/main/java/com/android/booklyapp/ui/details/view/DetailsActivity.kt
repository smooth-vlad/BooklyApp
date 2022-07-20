package com.android.booklyapp.ui.details.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.android.booklyapp.R
import com.android.booklyapp.databinding.ActivityDetailsBinding
import com.android.booklyapp.databinding.ActivityMainBinding
import com.android.booklyapp.ui.App
import com.android.booklyapp.ui.details.viewmodel.DetailsViewModel
import com.android.booklyapp.ui.main.adapter.BestSellerItemAdapter
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {
    companion object {
        const val BOOK_ID = "DetailsActivity.BookId"
    }

    private lateinit var binding: ActivityDetailsBinding

    @Inject
    lateinit var viewModelFactory: DetailsViewModel.Factory
    private val viewModel: DetailsViewModel by viewModels {
        DetailsViewModel.providesFactory(
            assistedFactory = viewModelFactory,
            bookId = intent.extras!!.getInt(BOOK_ID)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.getAppComponent(this).inject(this)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = ""

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_cart -> true // TODO navigate to cart screen
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}