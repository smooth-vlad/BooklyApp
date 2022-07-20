package com.android.booklyapp.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.booklyapp.data.ebook_api.classes.BestSeller
import com.android.booklyapp.databinding.BestSellerItemBinding
import com.android.booklyapp.ui.main.viewmodel.MainViewModel
import com.bumptech.glide.Glide

class BestSellerItemAdapter(private val data: List<BestSeller>) : RecyclerView.Adapter<BestSellerItemAdapter.ViewHolder>() {

    companion object {
        const val TAG = "BestSellerItemAdapter"
    }

    class ViewHolder(val binding: BestSellerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BestSellerItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.binding.titleTextView.text = item.title
        holder.binding.authorTextView.text = item.author
        holder.binding.priceTextView.text = "${item.price}€"
        holder.binding.ratingTextView.text = item.rate.score.toString()
        holder.binding.ratingAdditionalTextView.text = "(${item.rate.amount})"
        Glide.with(holder.binding.root)
            .load(item.image)
            .into(holder.binding.coverImageView)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}