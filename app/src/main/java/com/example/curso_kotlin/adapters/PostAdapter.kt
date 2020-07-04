package com.example.curso_kotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.curso_kotlin.R
import com.example.curso_kotlin.network.PostReponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post_list.view.*

class PostAdapter(private var data: List<PostReponse>, private val listener: PostHolder.OnAdapterListener) :
    RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflatedView = parent.inflate(R.layout.item_post_list, false)
        return PostHolder(inflatedView)
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    fun updateList(postList: List<PostReponse>) {
        this.data = postList
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post: PostReponse = this.data[position]
        holder.itemView.tv_feed_item_username.text = post.username
        holder.itemView.tv_feed_item_description.text = post.body
        holder.itemView.tv_feed_item_likes.text = post.likes.toString()

        if(!post.user_image.isBlank()) {
            Picasso.get()
                .load(post.user_image)
                .into(holder.itemView.iv_feed_row_profile)
        }
        if(!post.image.isBlank()) {
            Picasso.get()
                .load(post.image)
                .into(holder.itemView.iv_feed_item_main)
        }

        holder.itemView.setOnClickListener { listener.onItemClickListener(post) }
    }


    override fun getItemCount(): Int {
        return data.size
    }

    class PostHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (v != null) {
                Toast.makeText(v.context, "Item", Toast.LENGTH_SHORT).show()
            }
        }

        interface OnAdapterListener {
            fun onItemClickListener( item: PostReponse)
        }

    }
}