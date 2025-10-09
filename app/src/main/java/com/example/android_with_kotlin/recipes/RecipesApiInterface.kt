package com.example.android_with_kotlin.recipes

import retrofit2.Call
import retrofit2.http.GET

interface RecipesApiInterface {
    @GET("recipes")
    fun getRecipesData() : Call<RecipesData>

}