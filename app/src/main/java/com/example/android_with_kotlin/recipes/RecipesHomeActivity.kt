package com.example.android_with_kotlin.recipes

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class RecipesHomeActivity : AppCompatActivity() {
    lateinit var recipesRecyclerView : RecyclerView
    lateinit var myRecipesAdapter : MyRecipesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipes_home)
        recipesRecyclerView = findViewById(R.id.recipesRecyclerView)
      val retrofitBuilder = Retrofit.Builder()
          .baseUrl("https://dummyjson.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(RecipesApiInterface::class.java)
        val retrofitData = retrofitBuilder.getRecipesData()
        retrofitData.enqueue(object : retrofit2.Callback<RecipesData?> {
            override fun onResponse(
                call: Call<RecipesData?>,
                response: Response<RecipesData?>
            ) {
                val responseBody = response.body()
                val recipeList = responseBody?.recipes!!
                myRecipesAdapter  = MyRecipesAdapter(this@RecipesHomeActivity,recipeList)
                recipesRecyclerView.adapter = myRecipesAdapter
                recipesRecyclerView.layoutManager = LinearLayoutManager(this@RecipesHomeActivity)
            }

            override fun onFailure(
                call: Call<RecipesData?>,
                t: Throwable
            ) {
                Log.d("RecipesHomeActivity", "onFailure: "+t.message)
            }

        })
    }
}