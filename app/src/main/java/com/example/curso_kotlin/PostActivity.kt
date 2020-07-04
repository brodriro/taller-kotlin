package com.example.curso_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.curso_kotlin.adapters.PostAdapter
import com.example.curso_kotlin.adapters.RecyclerAdapter
import com.example.curso_kotlin.network.PostReponse
import com.example.curso_kotlin.network.Repository
import com.example.curso_kotlin.network.UserResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class PostActivity : AppCompatActivity(), PostAdapter.PostHolder.OnAdapterListener{

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        adapter = PostAdapter(ArrayList(), this)
        linearLayoutManager = LinearLayoutManager(this)
        postRecyclerView.layoutManager= linearLayoutManager
        postRecyclerView.adapter = adapter

        callService()
    }

    private fun callService() {
        val service = Repository.RetrofitRepository.getService()

        GlobalScope.launch(Dispatchers.IO) {
            val response =  service.getPosts()

            withContext(Dispatchers.Main) {

                try {
                    if(response.isSuccessful) {
                        val posts : List<PostReponse>?  = response.body()
                        if( posts != null) updateInfo(posts)
                    }else{
                        Toast.makeText(this@PostActivity, "Error ${response.code()}", Toast.LENGTH_LONG).show()
                    }
                }catch (e : HttpException) {
                    Toast.makeText(this@PostActivity, "Error ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun updateInfo(list: List<PostReponse>) {
        adapter.updateList(list)
    }

    override fun onItemClickListener(item: PostReponse) {
        Toast.makeText(this, "Click item ${item.username}", Toast.LENGTH_LONG).show()

        val postString : String = Gson().toJson(item, PostReponse::class.java)
        Log.d("GSON Class to String", postString )
        /**
         * puedes enviar los extras a una pantalla de detalle
         */

        val post : PostReponse = Gson().fromJson(postString, PostReponse::class.java)
        Log.d("GSON string to class", post.username )
    }


}
