package com.example.individual5m6.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.individual5m6.R
import com.example.individual5m6.model.Objeto
import kotlinx.android.synthetic.main.item_view.view.*

class ItemAdapter(private val objetos: List<Objeto>, private val onClick: (Objeto) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val objeto = objetos[position]
        holder.bind(objeto)
        holder.itemView.setOnClickListener { onClick(objeto) }
    }

    override fun getItemCount() = objetos.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(objeto: Objeto) {
            itemView.titleTextView.text = objeto.title
            Glide.with(itemView.context)
                .load(objeto.imageUrl)
                .into(itemView.imageView)
        }
    }
}