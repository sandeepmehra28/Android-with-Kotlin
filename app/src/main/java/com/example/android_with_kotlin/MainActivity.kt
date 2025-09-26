package com.example.android_with_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R.id.btnDark
import com.example.android_with_kotlin.intents.ImplicitIntentActivity
import com.example.android_with_kotlin.multiple_intents_class.CafeMainActivity
import com.example.android_with_kotlin.views.WebViewActivity
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnDark = findViewById<Button>(btnDark)
        val btnRead = findViewById<Button>(R.id.btnRead)
        val layout = findViewById<LinearLayout>(R.id.LinearLayout)
        val btnClick = findViewById<Button>(R.id.btnClickme)
        val btnImIntent = findViewById<Button>(R.id.btnImplicitIntent)
        val btnWebView = findViewById<Button>(R.id.btnWebView)
        val mulIntents = findViewById<Button>(R.id.btnMulIntent)
        Log.i("INFO TAG","THIS IS MY INFO TAG")
        btnRead.setOnClickListener {
            layout.setBackgroundResource(R.color.yellow)
        }

        btnDark.setOnClickListener {
            layout.setBackgroundResource(R.color.black)
        }
        btnClick.setOnClickListener {
           val  intent  = Intent(this, second_activity::class.java)
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
       btnImIntent.setOnClickListener {
           val intent =  Intent(this, ImplicitIntentActivity::class.java)
           startActivity(intent)
       }
        btnWebView.setOnClickListener {
            val  intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
        mulIntents.setOnClickListener {
            val intent = Intent(this, CafeMainActivity::class.java)
            startActivity(intent)
        }
    }
}