package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), BreedsAdapter.OnBreedClickListener {

    private lateinit var breedsRecyclerView: RecyclerView
    private val breedNames = listOf("Labrador", "Bulldog", "Poodle", "Beagle")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        breedsRecyclerView = findViewById(R.id.breedsRecyclerView)
        breedsRecyclerView.layoutManager = LinearLayoutManager(this)
        breedsRecyclerView.adapter = BreedsAdapter(breedNames, this)
    }

    override fun onBreedClick(breedName: String) {
        val intent = Intent(this, BreedImagesActivity::class.java)
        intent.putExtra("breedName", breedName)
        startActivity(intent)
    }
}
