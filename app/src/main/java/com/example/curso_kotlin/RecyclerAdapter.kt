package com.example.curso_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.item_detail.view.*

class RecyclerAdapter(private val data: ArrayList<Feed>) :  RecyclerView.Adapter<RecyclerAdapter.FeedHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.FeedHolder {
        val inflatedView = parent.inflate(R.layout.item_detail, false)
        return FeedHolder(inflatedView)
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.FeedHolder, position: Int) {
        val feed : Feed = this.data[position]
        holder.itemView.item_detail_username.text = feed.username
        holder.itemView.item_detail_lastname.text = feed.lastname

        
        Picasso.get()
            .load(feed.image)
            .resize(100,100)
            .centerCrop()
            .into(holder.itemView.item_detail_image)

        //GLIDE O PICASSO PARA IMAGEVIEW
    }


    override fun getItemCount(): Int {
        return data.size
    }

    class FeedHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var feed : Feed? = null

        init {
            v.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            if (v != null) {
                Toast.makeText(v.context, "Item", Toast.LENGTH_SHORT).show()
            }
        }

    }
}