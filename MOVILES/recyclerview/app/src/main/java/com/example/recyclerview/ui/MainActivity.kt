package com.example.recyclerview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recyclerview.R
import com.example.recyclerview.domain.Persona

class MainActivity : AppCompatActivity() {

    private var temp: Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = this.findViewById<Button>(R.id.button)

        temp = 0;


        button.setOnClickListener {

            val editText = this.findViewById<EditText>(R.id.editTextTextPersonName)
            temp++

            editText.setText(temp.toString())
//            val intent =  Intent(this, ReciclerActivity::class.java)
//
//            intent.putExtra(getString(R.string.persona),
//                arrayListOf(Persona("nombre","appelidos",10),
//                    Persona("nombre2","apellido2",90)))
//            startActivity(intent)

        }


    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        Log.i("MyTag", "onSaveInstanceState")

        outState.putInt("COUNT_KEY", temp)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MyTag", "onRestoreInstanceState")

        temp = savedInstanceState.getInt("COUNT_KEY")
    }
}

