package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class BreedsAdapter(
    private val breedNames: List<String>,
    private val onBreedClickListener: OnBreedClickListener
) : RecyclerView.Adapter<BreedsAdapter.BreedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dog_breed, parent, false)
        return BreedViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breedName = breedNames[position]
        holder.breedButton.text = breedName
        holder.breedButton.setOnClickListener {
            onBreedClickListener.onBreedClick(breedName)
        }
    }

    override fun getItemCount(): Int = breedNames.size

    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedButton: Button = itemView.findViewById(R.id.breed_button)
    }

    interface OnBreedClickListener {
        fun onBreedClick(breedName: String)
    }
}

