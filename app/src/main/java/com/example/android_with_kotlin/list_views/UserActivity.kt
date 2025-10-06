package com.example.android_with_kotlin.list_views

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("imageId",R.drawable.pic0)
        val nameTv = findViewById<TextView>(R.id.tvUserName)
        val phoneTv = findViewById<TextView>(R.id.tvUserPhone)
        val image = findViewById<CircleImageView>(R.id.profile_image)

        nameTv.text = name
        phoneTv.text = phone
        image.setImageResource(imageId)

    }
}