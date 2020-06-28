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
        feedList.add(Feed("Brian", "Rodriguez", "https://img2.freepng.es/20180623/iqh/kisspng-computer-icons-avatar-social-media-blog-font-aweso-avatar-icon-5b2e99c40ce333.6524068515297806760528.jpg"))
        feedList.add(Feed("Arturo", "Ulloa", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRPla3rTBqTsLRZLSyj7Zv_DV_WLc6LWwZnlw&usqp=CAU"))
        feedList.add(Feed("Cesar", "Heladio", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSerOjbOByfQamF_J_CY4O691ynZQLRnmcytg&usqp=CAU"))
        feedList.add(Feed("Henrry", "Wong", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSIpIlh3AtO_FIfEIBARgn7F9R9CQqvMzlFBw&usqp=CAU"))
        feedList.add(Feed("Rebeca", "Días", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTLaoiVChJYmLSdfsWtgKL_deeSguvjFYeHqw&usqp=CAU"))
        feedList.add(Feed("Gustavo", "Perez", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTTrtbQWAUbo97OQOHKopnMNwKh5lDBnlzpNw&usqp=CAU"))
        feedList.add(Feed("Wilson", "Vargas","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQfOhY4yKyXrGIKZJCyuZ6heQeulfsgZypN-Q&usqp=CAU"))

        adapter = RecyclerAdapter(feedList)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager= linearLayoutManager
        recyclerView.adapter = adapter
    }
}
