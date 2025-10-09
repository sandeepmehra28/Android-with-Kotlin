package com.example.android_with_kotlin.apis

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProductData() : Call<MyData>
}