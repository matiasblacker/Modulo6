package com.example.individual1m6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.individual1m6.databinding.FragmentTareaBinding

class TareaFragment : Fragment() {
    private lateinit var binding: FragmentTareaBinding
    private val tareaViewModel: TareaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTareaBinding.inflate(inflater, container, false)
        val adapter = TareaAdapter()
        binding.recyclerViewTareas.adapter = adapter
        binding.recyclerViewTareas.layoutManager = LinearLayoutManager(requireContext())

        tareaViewModel.obtenerTareas.observe(viewLifecycleOwner) { tareas ->
            adapter.submitList(tareas)
        }

        return binding.root
    }
}