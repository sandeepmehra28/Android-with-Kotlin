package com.example.android_with_kotlin.recipes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R
import com.example.android_with_kotlin.databinding.ActivityRecipesMainBinding

class RecipesMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityRecipesMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
       binding.letsGoBtn.setOnClickListener {
           val intent = Intent(this, RecipesHomeActivity::class.java)
           startActivity(intent)
       }
    }
}