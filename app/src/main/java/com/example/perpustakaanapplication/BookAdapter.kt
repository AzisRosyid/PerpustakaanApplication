package com.example.perpustakaanapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.perpustakaanapplication.databinding.AdapterBookBinding

class BookAdapter(val listBook: ArrayList<Book>, val onItemClickCallback: OnItemClickCallback): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    class ViewHolder(val binding: AdapterBookBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        AdapterBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = listBook[position]

        holder.binding.title.text = book.title
        holder.binding.author.text = book.author

        Glide.with(holder.itemView)
            .load(listBook[position].photo)
            .into(holder.binding.image)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(book)
        }
    }

    override fun getItemCount(): Int = listBook.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Book)
    }
}