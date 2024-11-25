package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BreedImagesActivity : AppCompatActivity() {

    private lateinit var breedImagesRecyclerView: RecyclerView
    private lateinit var breedName: String
    private lateinit var imagesList: List<Int>  // Lista de imágenes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_images)

        // Obtiene el nombre de la raza desde el Intent
        breedName = intent.getStringExtra("breedName") ?: ""

        breedImagesRecyclerView = findViewById(R.id.breedImagesRecyclerView)

        // Configurar las imágenes basadas en el nombre de la raza
        imagesList = when (breedName) {
            "labrador" -> listOf(R.drawable.labrador, R.drawable.labrador2, R.drawable.labrador3)
            "bulldog" -> listOf(R.drawable.bulldog, R.drawable.bulldog2, R.drawable.bulldog3)
            "poodle" -> listOf(R.drawable.poodle, R.drawable.poodle2, R.drawable.poodle3)
            "beagle" -> listOf(R.drawable.beagle, R.drawable.beagle2, R.drawable.beagle3)
            else -> emptyList()
        }

        // Configurar el RecyclerView con el adaptador
        val imagesAdapter = DogImagesAdapter(imagesList)

        breedImagesRecyclerView.layoutManager = LinearLayoutManager(this)
        breedImagesRecyclerView.adapter = imagesAdapter
    }
}
