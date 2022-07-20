package com.android.booklyapp.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.android.booklyapp.R
import com.android.booklyapp.databinding.ActivityMainBinding
import com.android.booklyapp.ui.App
import com.android.booklyapp.ui.main.adapter.BestSellerItemAdapter
import com.android.booklyapp.ui.main.viewmodel.MainViewModel
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