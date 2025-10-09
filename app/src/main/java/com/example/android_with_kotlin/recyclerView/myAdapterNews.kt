package com.example.android_with_kotlin.recyclerView

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R
import com.google.android.material.imageview.ShapeableImageView

class myAdapterNews (var newsArrayList : ArrayList<News> , var context : Activity) : RecyclerView.Adapter<myAdapterNews.MyViewHolder>() {
    private lateinit var myListener : onItemClickListener
    interface onItemClickListener {
        fun onItemClicking(position: Int)
    }
    fun setOnItemClickListener(listener : onItemClickListener){
        myListener = listener
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): myAdapterNews.MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_each_row,parent,false)
       return MyViewHolder(itemView,myListener)
    }

    override fun onBindViewHolder(holder: myAdapterNews.MyViewHolder, position: Int) {
        var currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)

    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }
    class MyViewHolder(itemView : View , listener : onItemClickListener) : RecyclerView.ViewHolder (itemView){
        val hTitle  =   itemView.findViewById<TextView>(R.id.headingTitile)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init{
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)

            }
        }

    }
}