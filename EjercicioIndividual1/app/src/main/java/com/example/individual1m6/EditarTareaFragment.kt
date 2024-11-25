package com.example.individual1m6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.individual1m6.databinding.FragmentEditarTareaBinding

class EditarTareaFragment : Fragment() {
    private lateinit var binding: FragmentEditarTareaBinding
    private val tareaViewModel: TareaViewModel by viewModels()
    private val args: EditarTareaFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditarTareaBinding.inflate(inflater, container, false)


        val tareaId = args.tareaId
        tareaViewModel.obtenerTareaPorId(tareaId).observe(viewLifecycleOwner) { tarea ->
            tarea?.let {
                binding.inputTitulo.setText(it.titulo)
                binding.inputDescripcion.setText(it.descripcion)
            }
        }


        binding.botonGuardar.setOnClickListener {
            val titulo = binding.inputTitulo.text.toString()
            val descripcion = binding.inputDescripcion.text.toString()

            if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
                val tareaActualizada = Tarea(tareaId, titulo, descripcion)
                tareaViewModel.actualizar(tareaActualizada)
                Toast.makeText(requireContext(), "Tarea actualizada", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}