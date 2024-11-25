package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DogImagesAdapter(private val images: List<Int>) : RecyclerView.Adapter<DogImagesAdapter.DogImageViewHolder>() {

    class DogImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog_images, parent, false)
        return DogImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogImageViewHolder, position: Int) {
        val imageResId = images[position]
        holder.imageView.setImageResource(imageResId)
    }

    override fun getItemCount(): Int = images.size
}
