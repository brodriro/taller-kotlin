package com.example.curso_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)


        val feedList = ArrayList<Feed>()
        feedList.add(Feed("Brian", "Rodriguez"))
        feedList.add(Feed("Arturo", "Ulloa"))
        feedList.add(Feed("Cesar", "Heladio"))
        feedList.add(Feed("Henrry", "Wong"))
        feedList.add(Feed("Rebeca", "Días"))
        feedList.add(Feed("Gustavo", "Perez"))
        feedList.add(Feed("Wilson", "Vargas"))

        adapter = RecyclerAdapter(feedList)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager= linearLayoutManager
        recyclerView.adapter = adapter
    }
}
