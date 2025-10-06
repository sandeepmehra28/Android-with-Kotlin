package com.example.android_with_kotlin.list_views

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R
import com.example.android_with_kotlin.databinding.ActivityListView1Binding

class ListView1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityListView1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityListView1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val listView = findViewById<ListView>(R.id.ListViewItems)
        val taskItems = arrayListOf<String>()
        taskItems.add("check mails")
        taskItems.add("check updates")
        taskItems.add("start Learning")
        taskItems.add("revise Lecture")
        taskItems.add("solving questions")
        taskItems.add("Revise notes")
        val adapterForMyListView = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskItems)
        listView.adapter = adapterForMyListView
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = "Clicked on item : " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}