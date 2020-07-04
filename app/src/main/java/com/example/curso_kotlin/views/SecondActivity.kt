package com.example.curso_kotlin.views

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.curso_kotlin.R
import com.example.curso_kotlin.utils.mSharedPreferences

import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.item_detail.*
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {

    // static final String KEY_USUARIO= "usuario"
    companion object{
        const val KEY_USUARIO="user"
        const val KEY_PASSWORD="password"
        const val KEY_NAME = "name"
        const val KEY_DNI = "dni"
        const val KEY_LASTNAME="lastname"
        const val KEY_ADDRESS = "address"
    }
    var usuario : String? = null
    var nombre : String? = null
    var dni : String? = null
    var password: String? = null
    var lastname : String? = null
    var address : String? =null

    data class User(val user:String?, val password:String?, val dni:String?, val nombre:String?, val lastname:String?, val address:String? )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        val user : User? = createUser();
        if( user == null)  {
            Toast.makeText(this, "No se logró obtener el usuario", Toast.LENGTH_SHORT).show()
            return
        }
        item_detail_username.text = user.nombre
        item_detail_lastname.text = user.lastname
        item_detail_dni.text = user.dni
        item_detail_address.text = user.address

        fab.setOnClickListener { view ->
            Snackbar.make(view, "El usuario es ${user.nombre} ${user.lastname}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    private fun createUser() : User? {
/*
        usuario = obtener(KEY_USUARIO)
        password = obtener(KEY_PASSWORD)
        nombre = obtener(KEY_NAME)
        lastname = obtener(KEY_LASTNAME)
        dni = obtener(KEY_DNI)
        address = obtener(KEY_ADDRESS)*/

        val mShared  =
            mSharedPreferences(this)
        val session = mShared.getKey("session") ?: return null

        val sessionObj = JSONObject(session)

        usuario = sessionObj.getString(KEY_USUARIO)
        password = sessionObj.getString(KEY_PASSWORD)
        nombre = sessionObj.getString(KEY_NAME)
        lastname = sessionObj.getString(KEY_LASTNAME)
        dni = sessionObj.getString(KEY_DNI)
        address = sessionObj.getString(KEY_ADDRESS)


        val user = User(
            usuario, password, dni, nombre, lastname, address
        )
        /*val user = User(
            intent.getStringExtra(KEY_USUARIO),
            intent.getStringExtra(KEY_PASSWORD),
            intent.getStringExtra(KEY_DNI),
            intent.getStringExtra(KEY_NAME),
            intent.getStringExtra(KEY_LASTNAME),
            intent.getStringExtra(KEY_ADDRESS)
        )*/
        return user
    }

    private fun obtener(key: String) : String? {
        //val sharedPref = applicationContext.getSharedPreferences("CURSO_KOTLIN", Context.MODE_PRIVATE)
        //return sharedPref.getString(key, "none")
        return mSharedPreferences(this).getKey(key)
    }

}
