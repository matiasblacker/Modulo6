package com.example.individual3m6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RealEstateAdapter(private val properties: List<RealEstate>) :
    RecyclerView.Adapter<RealEstateAdapter.RealEstateViewHolder>() {

    class RealEstateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val priceTextView: TextView = itemView.findViewById(R.id.text_price)
        val typeTextView: TextView = itemView.findViewById(R.id.text_type)
        val imageView: ImageView = itemView.findViewById(R.id.image_property)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealEstateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_real_estate, parent, false)
        return RealEstateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RealEstateViewHolder, position: Int) {
        val property = properties[position]
        holder.priceTextView.text = "$${property.price}"
        holder.typeTextView.text = property.type
        Glide.with(holder.itemView.context).load(property.imgSrc).into(holder.imageView)
    }

    override fun getItemCount() = properties.size
}