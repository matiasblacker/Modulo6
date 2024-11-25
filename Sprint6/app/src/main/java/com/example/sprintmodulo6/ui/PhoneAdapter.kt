package com.example.sprintmodulo6.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprintmodulo6.databinding.ItemPhoneBinding
import com.example.sprintmodulo6.model.Phone

class PhoneAdapter(private val onItemClick: (Phone) -> Unit) :
    ListAdapter<Phone, PhoneAdapter.PhoneViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val binding = ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = getItem(position)
        holder.bind(phone)
    }

    inner class PhoneViewHolder(private val binding: ItemPhoneBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(phone: Phone) {
            binding.phoneName.text = phone.name
            binding.phonePrice.text = phone.price.toString()

            // Cargar la imagen usando Glide
            Glide.with(binding.phoneImage.context)
                .load(phone.image)
                .into(binding.phoneImage)

            binding.root.setOnClickListener { onItemClick(phone) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Phone>() {
        override fun areItemsTheSame(oldItem: Phone, newItem: Phone) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Phone, newItem: Phone) = oldItem == newItem
    }
}