package com.example.curso_kotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    //var usuario : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        //usuario = intent.getStringExtra("usuario")

        fab.setOnClickListener { view ->
            /*Snackbar.make(view, "El usuario es $usuario", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }
    }

}
