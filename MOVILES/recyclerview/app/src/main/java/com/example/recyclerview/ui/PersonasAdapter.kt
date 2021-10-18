package com.example.recyclerview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.data.Ejemplo
import com.example.recyclerview.databinding.ItemPersonaBinding
import com.example.recyclerview.domain.Persona

class PersonasAdapter(
    private val personas: List<Ejemplo>,
    private val onClickBoton: (String) -> Unit
) : RecyclerView.Adapter<PersonasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //ProductoViewHolder(ItemProductoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false))
        return PersonasViewHolder(layoutInflater.inflate(R.layout.item_persona, parent, false))
    }


    override fun onBindViewHolder(holder: PersonasViewHolder, position: Int) {
        holder.render(personas[position],onClickBoton)
    }

    override fun getItemCount(): Int = personas.size



}

class PersonasViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemPersonaBinding.bind(view)

    fun render(persona: Ejemplo,
               onClickBoton: (String) -> Unit) {

        val text = view.findViewById<TextView>(R.id.tvNombre)
        //text = binding.tvNombre
        text.setText(persona.name)



        view.findViewById<TextView>(R.id.tvApellidos).text = persona.id.toString()

        view.findViewById<TextView>(R.id.button2).setOnClickListener {
            onClickBoton(text.text.toString());
        }

    }
}