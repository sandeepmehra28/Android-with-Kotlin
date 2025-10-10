package com.example.android_with_kotlin.carts

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyCartAdapter(
    private val context: Activity,
    private val productList: List<Product>
) : RecyclerView.Adapter<MyCartAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.cart_eachrow, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.title.text = currentItem.title
        holder.price.text = "₹${currentItem.price}"
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.cartTittle)
        val price: TextView = itemView.findViewById(R.id.cartPrice)
        val image: ShapeableImageView = itemView.findViewById(R.id.cartImage)
    }
}
