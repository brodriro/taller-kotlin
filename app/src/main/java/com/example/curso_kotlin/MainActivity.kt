package com.example.curso_kotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.item_detail.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    // const  => El valor se determina en tiempo de compilacion
    // val  => El valor se puede determinar en tiempo de ejecución
    // var => El valor se puede modificar en tiempo de ejecucion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        Log.d("Estado", "onCreate")

        btnLogin.setOnClickListener{view ->
            if(et_username.text.toString() == "admin") {
                val intent = Intent(this, SecondActivity::class.java)

                guardar(et_username.text.toString(), et_password.text.toString(),
                    "Brian", "Rodríguez",
                    "10020030", "Av. Peru #455")
/*
                intent.putExtra(SecondActivity.KEY_USUARIO, et_username.text.toString())
                intent.putExtra(SecondActivity.KEY_PASSWORD, et_password.text.toString() )
                intent.putExtra(SecondActivity.KEY_NAME, "Brian")
                intent.putExtra(SecondActivity.KEY_LASTNAME, "Rodríguez")
                intent.putExtra(SecondActivity.KEY_DNI, "10020030")
                intent.putExtra(SecondActivity.KEY_ADDRESS, "Av. Peru 455")*/

                startActivity(intent)
            }else {
                Snackbar.make(view, "Usuario incorrecto", Snackbar.LENGTH_LONG).show()
            }
        }
        fab.setOnClickListener { view ->

            // Intent intent = new Intent(this, SecondActivity.class); <- Java
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("usuario", "Everis")
            startActivity(intent)
        }
    }

    private fun guardarJson(usuario:String, password:String, name:String, lastname:String, dni:String, address:String  ) {
        val json = JSONObject()
        json.put(SecondActivity.KEY_USUARIO, usuario)
        json.put(SecondActivity.KEY_PASSWORD, password)
        json.put(SecondActivity.KEY_NAME, name)
        json.put(SecondActivity.KEY_LASTNAME, lastname)
        json.put(SecondActivity.KEY_DNI, dni)
        json.put(SecondActivity.KEY_ADDRESS, address)
        val sf = mSharedPreferences(this)
        sf.put("session", json.toString())
        sf.save()
    }
    private fun guardar(usuario:String, password:String, name:String, lastname:String, dni:String, address:String  ) {
        guardarJson(et_username.text.toString(), et_password.text.toString(),
            "Brian", "Rodríguez",
            "10020030", "Av. Peru #455")

       // val sharedPref = applicationContext.getSharedPreferences("CURSO_KOTLIN", Context.MODE_PRIVATE)
       // val editor: SharedPreferences.Editor = sharedPref.edit()

       val sf = mSharedPreferences(this)
        sf.put(SecondActivity.KEY_USUARIO, usuario)
        sf.put(SecondActivity.KEY_PASSWORD, password)
        sf.put(SecondActivity.KEY_NAME, name)
        sf.put(SecondActivity.KEY_LASTNAME, lastname)
        sf.put(SecondActivity.KEY_DNI, dni)
        sf.put(SecondActivity.KEY_ADDRESS, address)
        sf.save()

       /* editor.putString(SecondActivity.KEY_USUARIO, usuario)
        editor.putString(SecondActivity.KEY_PASSWORD, password)
        editor.putString(SecondActivity.KEY_NAME, name)
        editor.putString(SecondActivity.KEY_LASTNAME, lastname)
        editor.putString(SecondActivity.KEY_DNI, dni)
        editor.putString(SecondActivity.KEY_ADDRESS, address)
        editor.commit()*/
    }

    override fun onStart() {
        super.onStart()
        Log.d("Estado", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Estado", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Estado", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Estado", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Estado", "onDestroy")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Accediendo al menu", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
