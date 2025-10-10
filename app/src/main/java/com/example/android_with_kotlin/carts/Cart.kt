package com.example.android_with_kotlin.carts

data class Cart(
    val discountedTotal: Double,
    val id: Int,
    val products: List<Product>,
    val total: Double,
    val totalProducts: Int,
    val totalQuantity: Int,
    val userId: Int
)