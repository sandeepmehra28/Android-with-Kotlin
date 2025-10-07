package com.example.android_with_kotlin.practice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R

class ListViewPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_practice)
        val listView = findViewById<ListView>(R.id.practiceListView)
        supportActionBar?.hide()
        val arrayList  = arrayOf(
            "check mail",
            "check updates",
            "start learning",
            "revise lecture",
            "solving questions",
            "revise notes"
        )
        val adapterMyList = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList)
        listView.adapter = adapterMyList
        listView.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on item : " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        }

    }
}