package com.example.android_with_kotlin.recipes

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyRecipesAdapter (val context  : Activity , val recipesArrayList : List<Recipe>) :
RecyclerView.Adapter<MyRecipesAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
      val itemView  = LayoutInflater.from(context).inflate(R.layout.recipes_each_items,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = recipesArrayList[position]
        holder.name.text = currentItem.name
        Picasso.get().load(currentItem.image).into(holder.image)
        holder.cuisine.text = currentItem.cuisine
    }

    override fun getItemCount(): Int {
       return recipesArrayList.size
    }

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
     var name : TextView
     var image : ShapeableImageView
     var cuisine : TextView

    init{
        name = itemView.findViewById(R.id.recipeTittle)
        image = itemView.findViewById(R.id.recipeImage)
        cuisine = itemView.findViewById(R.id.recipeCuisine)
    }
    }
}