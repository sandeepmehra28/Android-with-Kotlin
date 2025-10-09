package com.example.android_with_kotlin.apis

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainApiActivity : AppCompatActivity() {
  lateinit var recyclerView : RecyclerView
    lateinit var myAdapter : MyProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_api)
        recyclerView = findViewById(R.id.apiRecyclerView)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getProductData()
        retrofitData.enqueue(object : retrofit2.Callback<MyData?> {
            override fun onResponse(
                call: Call<MyData?>,
                response: Response<MyData?>
            ) {
              val respnseBody = response.body()
                val productList = respnseBody?.products!!
              myAdapter = MyProductAdapter(this@MainApiActivity,productList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainApiActivity)
            }

            override fun onFailure(
                call: Call<MyData?>,
                t: Throwable
            ) {
                Log.d("MainApiActivity", "onFailure: "+t.message)
            }

        })
    }
}