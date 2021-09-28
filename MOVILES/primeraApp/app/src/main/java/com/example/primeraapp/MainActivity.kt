package com.example.primeraapp

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.primeraapp.databinding.ActivityMainBinding


data class Persona(var nombre:String,var appelido:String = "Perez")


class MainActivity : AppCompatActivity() {

    private val listaPersonas  = mutableListOf<Persona>()


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var person = Persona("","")
        person.appelido = ""


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val boton = this.findViewById<Button>(R.id.boton)

        val etName = this.findViewById<EditText>(R.id.etName)

//        boton.text = "HOLA BOTON"
//        ponerlisteners()
        binding.boton.setSafeOnClickListener {
            Log.d("::: TAG","Mensaje")
            val texto = etName.text

//            if (texto.toString() == "asdasd")
            Toast.makeText( this, " Hola ${texto}", Toast.LENGTH_SHORT).show()

        }

        binding.etName.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus)
                closeSoftKeyboard(this,etName)
        }

    }
    /* hide soft keyboard after writing and sending message or any */
    private fun closeSoftKeyboard(context: Context, v: View) {
        val iMm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        iMm.hideSoftInputFromWindow(v.windowToken, 0)
        v.clearFocus()
    }

    fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

//    private fun ponerlisteners() {
//        boton.setOnClickListener {
//            val texto = etName.text
//            Toast.makeText( this, " Hola ${texto}", Toast.LENGTH_SHORT).show()
//
//        }
//    }

}