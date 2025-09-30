package com.example.android_with_kotlin.viewbinding

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import com.example.android_with_kotlin.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSU.setOnClickListener {
            if(binding.checkBox.isChecked){
                //open new screen

            }else{
                binding.checkBox.buttonTintList = ColorStateList.valueOf(android.graphics.Color.RED)
                Toast.makeText(this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }

    }
}