package com.example.android_with_kotlin.intents

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.android_with_kotlin.R
import com.example.android_with_kotlin.R.id.cardCamera
import androidx.core.net.toUri

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)
        val webBtn = findViewById<CardView>(R.id.cardWeb)
        val camBtn = findViewById<CardView>(cardCamera)
        webBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = "https://wpportfolio.net/website-portfolio/".toUri()
            startActivity(intent)
        }
        camBtn.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

    }
}