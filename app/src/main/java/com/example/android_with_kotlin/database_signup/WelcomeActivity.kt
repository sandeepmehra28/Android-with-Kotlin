package com.example.android_with_kotlin.database_signup

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra(SigninActivity.KEY2)
        val mail = intent.getStringExtra(SigninActivity.KEY1)
        val userId = intent.getStringExtra(SigninActivity.KEY3)

        val welcometext = findViewById<TextView>(R.id.tvWelcome)
        val mailText = findViewById<TextView>(R.id.tvMail)
        val idText = findViewById<TextView>(R.id.tvUnique)

        welcometext.text = "Welcome $name"
        mailText.text = "Mail : $mail"
        idText.text = "UserID : $userId"
    }
}