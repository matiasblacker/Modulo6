package com.example.individual4m6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.individual4m6.adapter.PropertyAdapter
import com.example.individual4m6.model.Property
import com.example.individual4m6.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PropertyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = PropertyAdapter()
        recyclerView.adapter = adapter

        fetchProperties()
    }

    private fun fetchProperties() {
        val apiService = ApiService.create().getProperties()
        apiService.enqueue(object : Callback<List<Property>> {
            override fun onResponse(
                call: Call<List<Property>>,
                response: Response<List<Property>>
            ) {
                if (response.isSuccessful) {
                    adapter.setProperties(response.body() ?: emptyList())
                }
            }

            override fun onFailure(call: Call<List<Property>>, t: Throwable) {
                // Manejar errores
            }
        })
    }
}