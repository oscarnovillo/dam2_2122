package com.example.recyclerview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.recyclerview.R
import com.example.recyclerview.domain.Persona

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = this.findViewById<Button>(R.id.button)
        
        button.setOnClickListener{
            val intent =  Intent(this, ReciclerActivity::class.java)

            intent.putExtra(getString(R.string.persona),
                arrayListOf(Persona("nombre","appelidos",10),
                    Persona("nombre2","apellido2",90)))
            startActivity(intent)
            
        }
    }
}