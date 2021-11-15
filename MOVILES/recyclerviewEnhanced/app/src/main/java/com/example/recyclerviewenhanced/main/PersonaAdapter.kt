package com.example.hiltmenu.ui.main

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewenhanced.R
import com.example.recyclerviewenhanced.databinding.ViewPersonaBinding
import com.example.recyclerviewenhanced.domain.Persona
import com.example.recyclerviewenhanced.main.SwipeGesture


class PersonaAdapter(
    context: Context,
    private val onDelete: (persona: Persona) -> Unit
) :
    ListAdapter<Persona, PersonaAdapter.ItemViewholder>(DiffCallback()) {

    private var selectedItem = mutableListOf<Persona>()

    fun getSelectedItems() = selectedItem.toList()

    private var selectedMode: Boolean = false

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
                selectedMode = !selectedMode
                notifyDataSetChanged()
                true
            }
            itemView.setOnClickListener {
                if (selectedMode) {
                    if (!binding.selected.isChecked) {
                        itemView.setBackgroundColor(Color.GREEN)
                        binding.selected.isChecked = true
                        notifyItemChanged(adapterPosition)
                        selectedItem.add(item)
                    } else {
                        itemView.setBackgroundColor(Color.WHITE)
                        selectedItem.remove(item)
                        binding.selected.isChecked = false
                        notifyItemChanged(adapterPosition)

                    }
                }
            }

            with(binding) {
                tvNombre.text = item.nombre
                tvId.text = item.id.toString()
                if (selectedMode)
                    selected.visibility = View.VISIBLE
                else
                    selected.visibility = View.GONE

                if (selected.isChecked) {
                    itemView.setBackgroundColor(Color.GREEN)
                    selected.visibility = View.VISIBLE
                } else {
                    itemView.setBackgroundColor(Color.WHITE)
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

    val swipeGesture = object : SwipeGesture(context) {

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (!selectedMode) {
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        onDelete(currentList[viewHolder.adapterPosition])
                    }
                }
            }
        }
    }


}


