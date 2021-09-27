package com.example.recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.domain.Persona
import com.google.android.material.snackbar.Snackbar

class ReciclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler)

        val persona = intent.getParcelableArrayListExtra<Persona>(getString(R.string.persona))
        Toast.makeText(this , " ${persona?.get(0)?.nombre}", Toast.LENGTH_SHORT).show()

        val rvPersona = this.findViewById<RecyclerView>(R.id.rvPersonas)
        Snackbar.make(rvPersona, " ${persona?.get(0)?.nombre} ", Snackbar.LENGTH_SHORT).show()
        persona?.let {
            rvPersona.adapter = PersonasAdapter(it)
            rvPersona.layoutManager = GridLayoutManager(this@ReciclerActivity,2)
        }


    }
}