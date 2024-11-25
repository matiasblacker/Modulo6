package com.example.sprintmodulo6.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.sprintmodulo6.databinding.FragmentPhoneDetailBinding
import com.example.sprintmodulo6.model.Phone
import com.example.sprintmodulo6.viewmodel.PhoneDetailViewModel

class PhoneDetailFragment : Fragment() {
    private var _binding: FragmentPhoneDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PhoneDetailViewModel by viewModels()
    private val args: PhoneDetailFragmentArgs by navArgs() // Argumentos de navegación

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhoneDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener detalles del teléfono usando el ID recibido en los argumentos
        val phoneId = args.phoneId
        viewModel.getPhoneDetails(phoneId)

        viewModel.phone.observe(viewLifecycleOwner) { phone ->
            phone?.let { showPhoneDetails(it) }
        }

        // Configurar el botón de enviar correo
        binding.sendEmailButton.setOnClickListener { sendEmail(viewModel.phone.value) }
    }

    private fun showPhoneDetails(phone: Phone) {
        binding.phoneName.text = phone.name
        binding.phonePrice.text = phone.price.toString()
        binding.phoneCredit.text = if (phone.credit) "Acepta Crédito" else "Sólo Efectivo"

        // Cargar imagen con Glide
        Glide.with(this)
            .load(phone.image)
            .into(binding.phoneImage)
    }

    private fun sendEmail(phone: Phone?) {
        phone?.let {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("info@novaera.cl"))
                putExtra(Intent.EXTRA_SUBJECT, "Consulta ${phone.name} id ${phone.id}")
                putExtra(Intent.EXTRA_TEXT, "Hola\n\nVi el teléfono ${phone.name} de código ${phone.id} y me gustaría que me contactaran a este correo o al siguiente número _______.\n\nQuedo atento.")
            }
            startActivity(Intent.createChooser(intent, "Enviar correo"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}