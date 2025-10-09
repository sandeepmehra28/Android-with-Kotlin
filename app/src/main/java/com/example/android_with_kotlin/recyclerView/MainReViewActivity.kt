package com.example.android_with_kotlin.recyclerView

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_with_kotlin.R

class MainReViewActivity : AppCompatActivity() {
    lateinit var myRecyclerView : RecyclerView
    lateinit var newsArrayList : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_re_view)
        supportActionBar?.hide()
    myRecyclerView = findViewById(R.id.recyclerViewID)
        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
        )
        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions"
        )
        val newsContant  = arrayOf(
           getString(R.string.news_contant),
            getString(R.string.news_contant),
            getString(R.string.news_contant),
            getString(R.string.news_contant),
            getString(R.string.news_contant)

        )

       myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for(index in newsImageArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index],newsContant[index])
            newsArrayList.add(news)
        }
        val myAdapter = myAdapterNews(newsArrayList,this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : myAdapterNews.onItemClickListener{
            override fun onItemClicking(position: Int) {
            val intent = Intent(this@MainReViewActivity,NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newscontant",newsArrayList[position].newsContant)
                startActivity(intent)

            }

        })

    }
}