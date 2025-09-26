package com.example.android_with_kotlin.multiple_intents_class

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R

class CafeMainActivity : AppCompatActivity() {
    companion object{
        const val KEY = "com.example.android_with_kotlin.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafe_main)
        val or1 = findViewById<EditText>(R.id.order1)
        val or2 = findViewById<EditText>(R.id.order2)
        val or3 = findViewById<EditText>(R.id.order3)
        val or4 = findViewById<EditText>(R.id.order4)
        val orderBtn = findViewById<Button>(R.id.OrderBtn)
        orderBtn.setOnClickListener {
         val orderList = or1.text.toString() + " " + or2.text.toString() + " " + or3.text.toString() + " " + or4.text.toString()
          val intent = Intent(this,Orders::class.java)
            intent.putExtra(KEY,orderList)
            startActivity(intent)
        }
    }
}