package com.example.android_with_kotlin.bottom_navigationview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android_with_kotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        setContentView(R.layout.activity_navigation_main)
       val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
       replaceWithFragment(Home())
        bottomView.setOnItemSelectedListener {
         when(it.itemId){
             R.id.home->replaceWithFragment(Home())
             R.id.search->replaceWithFragment(Search())
             R.id.profile->replaceWithFragment(Profile())
             else ->{

             }
         }
            true
        }
    }
     @SuppressLint("SuspiciousIndentation")
     fun replaceWithFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flowLayoutView,fragment)
        fragmentTransaction.commit()
    }
}