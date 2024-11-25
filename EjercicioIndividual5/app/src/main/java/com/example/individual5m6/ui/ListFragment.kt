package com.example.individual5m6.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.individual5m6.R
import com.example.individual5m6.model.Objeto
import com.example.individual5m6.repository.ObjetoRepository
import com.example.sprintmodulo6.R
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private lateinit var objetoRepository: ObjetoRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        objetoRepository = ObjetoRepository(
            (activity?.application as MyApp).database.objetoDao(),
            (activity?.application as MyApp).apiService
        )

        lifecycleScope.launch {
            val objetos = objetoRepository.getObjetos()
            recyclerView.adapter = ItemAdapter(objetos) { objeto ->
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(objeto)
                findNavController().navigate(action)
            }
        }
    }
}