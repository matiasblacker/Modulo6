package com.example.individual2m6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var items = emptyList<Item>()

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.text_view_name)
        val priceTextView: TextView = itemView.findViewById(R.id.text_view_price)
        val quantityTextView: TextView = itemView.findViewById(R.id.text_view_quantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.nameTextView.text = currentItem.nombre
        holder.priceTextView.text = "${currentItem.precioUnitario}"
        holder.quantityTextView.text = "${currentItem.cantidad}"
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }
}