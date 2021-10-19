package com.example.recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.data.Ejemplo
import com.example.recyclerview.data.EjemploRepository
import com.example.recyclerview.domain.Persona
import com.google.android.material.snackbar.Snackbar

class ReciclerActivity : AppCompatActivity() {


    fun click(nombre:String){
        Snackbar.make(findViewById<RecyclerView>(R.id.rvPersonas)
            , " $nombre", Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler)

        val listaPersonas = EjemploRepository().getLista()
        Toast.makeText(this , "el nombre es ${listaPersonas?.get(0)?.name}", Toast.LENGTH_SHORT).show()

        val rvPersona = this.findViewById<RecyclerView>(R.id.rvPersonas)

        Snackbar.make(rvPersona, " ${listaPersonas?.get(0)?.name} ", Snackbar.LENGTH_SHORT).show()


        listaPersonas?.let {
            rvPersona.adapter = PersonasAdapter(it,::click)
            rvPersona.layoutManager = GridLayoutManager(this@ReciclerActivity,2)
        }



    }



}