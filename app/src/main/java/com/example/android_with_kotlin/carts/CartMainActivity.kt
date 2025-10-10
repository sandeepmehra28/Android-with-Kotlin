package com.example.android_with_kotlin.carts

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R
import com.example.android_with_kotlin.recipes.MyRecipesAdapter
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CartMainActivity : AppCompatActivity() {
    lateinit var cartRecyclerView : RecyclerView
    lateinit var myCartAdapter :  MyCartAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart_main)
        cartRecyclerView = findViewById(R.id.cartRecyclerView)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CartApiInterface::class.java)
        val retrofitData = retrofitBuilder.getCartData()
        retrofitData.enqueue(object : retrofit2.Callback<MyCartData?> {
            override fun onResponse(
                call: Call<MyCartData?>,
                response: Response<MyCartData?>
            ) {
                val responseBody = response.body()
                if (responseBody != null) {
                    // Flatten all products from all carts
                    val productList = responseBody.carts.flatMap { it.products }

                    myCartAdapter = MyCartAdapter(this@CartMainActivity, productList)
                    cartRecyclerView.layoutManager = LinearLayoutManager(this@CartMainActivity)
                    cartRecyclerView.adapter = myCartAdapter
                }

            }

            override fun onFailure(
                call: Call<MyCartData?>,
                t: Throwable
            ) {
                Log.d("CartMainActivity", "onFailure: "+t.message)
            }

        })
    }
}