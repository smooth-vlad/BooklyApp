package com.android.booklyapp.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.booklyapp.R
import com.android.booklyapp.data.ebook_api.classes.BookImage
import com.android.booklyapp.databinding.SimilarItemBinding
import com.bumptech.glide.Glide

class SimilarItemAdapter(private val data: List<BookImage>) : Adapter<SimilarItemAdapter.ViewHolder>() {
    class ViewHolder(val binding: SimilarItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SimilarItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        Glide.with(holder.binding.root)
            .load(item.image)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.similarCoverImageView)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}