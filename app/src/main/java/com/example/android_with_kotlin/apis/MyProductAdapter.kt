package com.example.android_with_kotlin.apis

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyProductAdapter (val context : Activity , val productArrayList : List<Product>): RecyclerView.Adapter<MyProductAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
         val itemView  = LayoutInflater.from(context).inflate(R.layout.eachitem_api,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = productArrayList[position]
        holder.tittle.text = currentItem.title
        //image view , how to show image in image view if the image is in form of url, 3rd party library
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var tittle : TextView
    var image : ShapeableImageView
    init{
        tittle = itemView.findViewById(R.id.ProductTittle)
        image = itemView.findViewById(R.id.productImage)
    }
    }
}