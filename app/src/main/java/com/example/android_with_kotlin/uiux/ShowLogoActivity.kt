package com.example.android_with_kotlin.uiux

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R

class ShowLogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_logo)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeUiUx::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}