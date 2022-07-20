package com.android.booklyapp.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import com.android.booklyapp.R
import com.android.booklyapp.data.ebook_api.classes.BookImage
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

            binding.shimmerBestSeller.visibility = View.GONE
            binding.bestSellerRecyclerView.visibility = View.VISIBLE
        }

        viewModel.carouselBooks.observe(this) { carouselItems ->
            binding.carousel.setAdapter(object : Carousel.Adapter {
                override fun count(): Int {
                    return carouselItems.size
                }

                override fun populate(view: View?, index: Int) {
                    Log.d("MainActivity", index.toString())
                    if (index < carouselItems.size) {
                        Glide.with(this@MainActivity)
                            .load(carouselItems[index].image)
                            .placeholder(R.drawable.placeholder)
                            .into(view as ImageView)
                    }
                }

                override fun onNewItem(index: Int) {
                }

            })
            binding.carousel.refresh()

            binding.shimmerCarousel.visibility = View.GONE
            binding.carouselLayout.visibility = View.VISIBLE
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