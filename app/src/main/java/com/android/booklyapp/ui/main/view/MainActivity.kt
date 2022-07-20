package com.android.booklyapp.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import com.android.booklyapp.R
import com.android.booklyapp.databinding.ActivityMainBinding
import com.android.booklyapp.ui.App
import com.android.booklyapp.ui.main.adapter.BestSellerItemAdapter
import com.android.booklyapp.ui.main.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.getAppComponent(this).inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.bestSellers.observe(this) {
            binding.bestSellerRecyclerView.adapter = BestSellerItemAdapter(it)
        }

        viewModel.carouselBooks.observe(this) { carouselItems ->
            Glide.with(this)
                .load(carouselItems[0].image)
                .into(binding.imageView0)
            Glide.with(this)
                .load(carouselItems[1].image)
                .into(binding.imageView1)
            Glide.with(this)
                .load(carouselItems[2].image)
                .into(binding.imageView2)
        }

        binding.toolbar.title = ""

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> true // TODO implement search
            else -> super.onOptionsItemSelected(item)
        }
    }
}