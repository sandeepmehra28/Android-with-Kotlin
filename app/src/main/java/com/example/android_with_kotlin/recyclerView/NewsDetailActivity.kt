package com.example.android_with_kotlin.recyclerView

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R
import com.google.android.material.imageview.ShapeableImageView

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)
        supportActionBar?.hide()
        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId",R.drawable.img1)
        val newsContant = intent.getStringExtra("newscontant")
         val headingTv = findViewById<TextView>(R.id.newsHeading)
         val headingImg = findViewById<ImageView>(R.id.newsImage)
         val newsContantTv = findViewById<TextView>(R.id.newsContant)
        headingTv.text = heading
        newsContantTv.text = newsContant
        headingImg.setImageResource(imageId)
    }
}