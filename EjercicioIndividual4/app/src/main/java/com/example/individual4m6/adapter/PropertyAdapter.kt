package com.example.individual4m6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.individual4m6.R
import com.example.individual4m6.model.Property

class PropertyAdapter : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {

    private var properties: List<Property> = listOf()

    fun setProperties(properties: List<Property>) {
        this.properties = properties
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_property, parent, false)
        return PropertyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        holder.bind(properties[position])
    }

    override fun getItemCount(): Int = properties.size

    class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.property_image)
        private val priceTextView: TextView = itemView.findViewById(R.id.property_price)

        fun bind(property: Property) {
            priceTextView.text = property.price.toString()
            Glide.with(itemView.context).load(property.imageUrl).into(imageView)
        }
    }
}