package com.example.android_with_kotlin.carts

import retrofit2.Call
import retrofit2.http.GET

interface  CartApiInterface {
    @GET("carts")
    fun getCartData() : Call<MyCartData>
}