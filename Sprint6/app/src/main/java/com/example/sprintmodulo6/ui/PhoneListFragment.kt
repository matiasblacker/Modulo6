package com.example.sprintmodulo6.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprintmodulo6.databinding.FragmentPhoneListBinding
import com.example.sprintmodulo6.ui.PhoneViewModel

class PhoneListFragment : Fragment() {
    private var _binding: FragmentPhoneListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PhoneViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhoneListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el RecyclerView con un adaptador
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PhoneAdapter { phone ->
            // Navegar a PhoneDetailFragment con el ID del teléfono seleccionado
            val action = PhoneListFragmentDirections.actionPhoneListFragmentToPhoneDetailFragment(phone.id)
            findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter

        // Observar la lista de teléfonos desde el ViewModel
        viewModel.phones.observe(viewLifecycleOwner) { phones ->
            adapter.submitList(phones)
        }

        // Llamar al método para obtener los datos de la API
        viewModel.fetchPhones()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}