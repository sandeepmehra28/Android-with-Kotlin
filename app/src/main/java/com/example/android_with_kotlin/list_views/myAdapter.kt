package com.example.android_with_kotlin.list_views

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.android_with_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class myAdapter (val contex : Activity , val arrayList: ArrayList<ListViewUserData>) :
    ArrayAdapter<ListViewUserData>(contex, R.layout.listview_eachrow,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(contex)
        val view = inflater.inflate(R.layout.listview_eachrow,null)
        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name  = view.findViewById<TextView>(R.id.tvName)
        val lastMsg = view.findViewById<TextView>(R.id.tvLastMsg)
        val lastMsgTime = view.findViewById<TextView>(R.id.tvLastMsgTime)
        name.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMsg
        lastMsgTime.text = arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imageId)
        return view
    }
}