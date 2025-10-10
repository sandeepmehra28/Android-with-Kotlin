package com.example.android_with_kotlin.carts

data class MyCartData(
    val carts: List<Cart>,
    val limit: Int,
    val skip: Int,
    val total: Int
)