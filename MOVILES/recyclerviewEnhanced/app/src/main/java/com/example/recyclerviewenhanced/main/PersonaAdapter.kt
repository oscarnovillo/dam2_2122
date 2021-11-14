package com.example.hiltmenu.ui.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewenhanced.R
import com.example.recyclerviewenhanced.databinding.ViewPersonaBinding
import com.example.recyclerviewenhanced.domain.Persona


class PersonaAdapter :
    ListAdapter<Persona, PersonaAdapter.ItemViewholder>(DiffCallback()) {

    private var selectedItem = mutableListOf<Persona>()

    fun getSelectedItems() = selectedItem.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_persona, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) = with(holder) {
        val item = getItem(position)
        bind(item)
    }


    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ViewPersonaBinding.bind(itemView)

        fun bind(item: Persona) {

            itemView.setOnLongClickListener {
                itemView.setBackgroundColor(Color.BLUE)
                println("LONG CLICK " + item)
                true
            }
            itemView.setOnClickListener {
                if (!binding.selected.isChecked) {
                    itemView.setBackgroundColor(Color.GREEN)
                    binding.selected.isChecked = true
                    selectedItem.add(item)
                }
                else
                {
                    itemView.setBackgroundColor(Color.WHITE)
                    selectedItem.remove(item)
                    binding.selected.isChecked = false

                }
                println("CLICK " + item)
            }

            with(binding) {
                tvNombre.text = item.nombre
                tvId.text = item.id.toString()
            }
        }


    }
}


class DiffCallback : DiffUtil.ItemCallback<Persona>() {
    override fun areItemsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem == newItem
    }
}