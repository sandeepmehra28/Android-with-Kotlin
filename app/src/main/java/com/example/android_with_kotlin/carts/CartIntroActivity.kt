package com.example.android_with_kotlin.carts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R

class CartIntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart_intro)
        val btn = findViewById<Button>(R.id.addCartBtn)
        btn.setOnClickListener {
            val intent = Intent(this, CartMainActivity::class.java)
            startActivity(intent)
        }
    }
}