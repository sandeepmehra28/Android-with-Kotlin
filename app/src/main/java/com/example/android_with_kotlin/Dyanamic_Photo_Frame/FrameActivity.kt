package com.example.android_with_kotlin.Dyanamic_Photo_Frame

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R

class FrameActivity : AppCompatActivity() {
    var currentImage = 0
    val totalImg = 5
    lateinit var image : ImageView
    var names = arrayOf("Actor First","Actor Second","Actor Third","Actor Fourth","Actor Fifth")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        setContentView(R.layout.activity_frame)
    val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.ActorNames)
        prev.setOnClickListener {
          val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
           image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (totalImg+currentImage-1)%totalImg
            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            text.text = names[currentImage]
        }
        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (totalImg+currentImage+1)%totalImg
            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            text.text = names[currentImage]
        }

    }
}