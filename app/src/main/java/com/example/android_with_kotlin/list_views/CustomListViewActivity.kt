package com.example.android_with_kotlin.list_views

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R


class CustomListViewActivity : AppCompatActivity() {
    lateinit var userArrayList : ArrayList<ListViewUserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view)
        supportActionBar?.hide()
        val name  = arrayOf("sandeep","sonu","sachin","chaman","dilip")
        val lastMsg = arrayOf("hey im good","hey im good","hey im good","hey im good","hey im good")
        val lastMsgTime = arrayOf("4:45 PM","4:45 PM","4:45 PM","4:45 PM","4:45 PM")
        val phoneNumber = arrayOf("9879456738","9879456738","9879456738","9879456738","9879456738")
        val imageId = intArrayOf(R.drawable.pic0,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4)
        userArrayList = ArrayList()
        for(eachIndec in name.indices){
            val u = ListViewUserData(name[eachIndec],lastMsg[eachIndec],lastMsgTime[eachIndec],phoneNumber[eachIndec],imageId[eachIndec])
            userArrayList.add(u)
        }
        val listView = findViewById<ListView>(R.id.CustomListView)
       listView.isClickable = true
        listView.adapter = myAdapter(this,userArrayList)
        listView.setOnItemClickListener { parent, view, position, id ->
           val userName = name[position]
            val userPhone = phoneNumber[position]
            val userImageId = imageId[position]
            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name",userName)
            i.putExtra("phone",userPhone)
            i.putExtra("imageId",userImageId)
            startActivity(i)

        }

    }
}