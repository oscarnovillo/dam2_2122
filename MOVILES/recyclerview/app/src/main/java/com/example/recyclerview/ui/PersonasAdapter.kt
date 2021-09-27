package com.example.recyclerview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.domain.Persona

class PersonasAdapter(private val personas:List<Persona>) : RecyclerView.Adapter<PersonasAdapter.PersonasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonasViewHolder(layoutInflater.inflate(R.layout.item_persona, parent, false))
    }



    override fun onBindViewHolder(holder: PersonasViewHolder, position: Int) {
        holder.render(personas[position])
    }

    override fun getItemCount(): Int {
        return personas.size
    }


    class PersonasViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun render( persona: Persona){

            view.findViewById<TextView>(R.id.tvNombre).text =  persona.nombre
            view.findViewById<TextView>(R.id.tvApellidos).text =  persona.apellidos

        }
    }

}
