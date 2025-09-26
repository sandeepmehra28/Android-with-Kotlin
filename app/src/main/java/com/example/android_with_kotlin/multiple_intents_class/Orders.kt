package com.example.android_with_kotlin.multiple_intents_class

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R

class Orders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_orders)
        val tvOrder = findViewById<TextView>(R.id.tVOrder)
        val orderOfCustomers = intent.getStringExtra(CafeMainActivity.KEY)
        tvOrder.text = "Your Order is: \n$orderOfCustomers"
    }
}