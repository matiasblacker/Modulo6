package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DogBreedAdapter(private val breeds: List<String>, private val imagesMap: Map<String, List<Int>>) :
    RecyclerView.Adapter<DogBreedAdapter.DogBreedViewHolder>() {

    // ViewHolder para el RecyclerView principal
    class DogBreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedName: TextView = itemView.findViewById(R.id.breed_name)
        val imagesRecyclerView: RecyclerView = itemView.findViewById(R.id.images_recycler_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogBreedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog_breed, parent, false)
        return DogBreedViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogBreedViewHolder, position: Int) {
        // Obtén el nombre de la raza de la lista y configúralo en el TextView
        val breed = breeds[position]
        holder.breedName.text = breed

        // Configura el RecyclerView anidado con el adaptador de imágenes
        val imagesAdapter = DogImagesAdapter(imagesMap[breed] ?: emptyList())
        holder.imagesRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.imagesRecyclerView.adapter = imagesAdapter
    }

    override fun getItemCount(): Int = breeds.size
}
