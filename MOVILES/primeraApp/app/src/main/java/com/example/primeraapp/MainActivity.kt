package com.example.primeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = this.findViewById<Button>(R.id.boton)
        val etName = this.findViewById<EditText>(R.id.etName)
        boton.text = "HOLA BOTON"
//        ponerlisteners()
        boton.setOnClickListener {
            val texto = etName.text
            Toast.makeText( this, " Hola ${texto}", Toast.LENGTH_SHORT).show()

        }

    }

//    private fun ponerlisteners() {
//        boton.setOnClickListener {
//            val texto = etName.text
//            Toast.makeText( this, " Hola ${texto}", Toast.LENGTH_SHORT).show()
//
//        }
//    }

}