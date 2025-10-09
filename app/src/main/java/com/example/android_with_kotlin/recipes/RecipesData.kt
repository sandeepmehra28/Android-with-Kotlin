package com.example.android_with_kotlin.recipes

data class RecipesData(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)