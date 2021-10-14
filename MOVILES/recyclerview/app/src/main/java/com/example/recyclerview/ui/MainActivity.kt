package com.example.recyclerview.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.recyclerview.R
import com.example.recyclerview.data.Ejemplo
import com.example.recyclerview.data.EjemploRepository
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.domain.Persona
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import timber.log.Timber
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {

    private var temp: Int = 0
    private lateinit var binding: ActivityMainBinding


    private lateinit var editText : EditText
    private lateinit var imageview : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        val button = this.findViewById<Button>(R.id.button)

        editText = this.findViewById<EditText>(R.id.editTextTextPersonName)
        imageview = this.findViewById<ImageView>(R.id.imageView)

        temp = 0;


        try {
            val inputStream: InputStream = assets.open("file.txt")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            val string = String(buffer)
            editText.setText(string)

//            val moshi = Moshi.Builder()
//                .addLast(KotlinJsonAdapterFactory())
//                .build()

            val ejemplo = EjemploRepository(assets.open("data.json")).getLista()[0]

            editText.setText(getString(R.string.place).format(ejemplo.path,ejemplo.extension))

          imageview.load("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg")
            EjemploRepository().addEjemplo(Ejemplo("nombre","appelidos",10, LocalDateTime.now(),"",""))

           // imageview.load(Uri.parse("file:///android_asset/image.jpg"))
            //imageview.load(File("/asset/lion.jpg"))

//            imageview.load("https://image.tmdb.org/t/p/w185/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg"){
//                transformations(CircleCropTransformation())
//            }

//            val imageLoader = ImageLoader(this)
//            val request = ImageRequest.Builder(this)
//                .data("https://androidappz.co.in/images/phonewhite.png")
//                .target(
//                    onStart = { placeholder ->
//                        // Handle the placeholder drawable.
//                    },
//                    onSuccess = { result ->
//                        // Handle the successful result.
//                    },
//                    onError = { error ->
//                       Log.e(error.toString(),"mensaje error")
//                    }
//                )
//
//                .build()
//            imageLoader.execute(request)



        } catch (e: IOException) {
            Timber.e(e,"Error leyendo fichero")
        }


        button.setOnClickListener {
            temp++

            editText.setText(temp.toString())
            val intent =  Intent(this, ReciclerActivity::class.java)

            val repo = EjemploRepository(assets.open("data.json"))

//            intent.putExtra(getString(R.string.persona),
//                arrayListOf(Ejemplo("nombre","appelidos",10, LocalDateTime.now(),"",""),
//                    Ejemplo("nombre","appelidos",10, LocalDateTime.now(),"","")))

//            intent.putExtra(getString(R.string.persona),
//                repo.getLista())

            startActivity(intent)


        }

    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        Timber.i("onSaveInstanceState")

        outState.putInt("COUNT_KEY", temp)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MyTag", "onRestoreInstanceState")

        temp = savedInstanceState.getInt("COUNT_KEY")
    }
}

