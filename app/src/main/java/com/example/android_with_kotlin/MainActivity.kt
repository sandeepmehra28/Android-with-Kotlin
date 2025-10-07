package com.example.android_with_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.Dyanamic_Photo_Frame.FrameActivity
import com.example.android_with_kotlin.customize_dialogbox.CDMainActivity
import com.example.android_with_kotlin.database_signup.SignupActivity
import com.example.android_with_kotlin.databinding.ActivityMainBinding
import com.example.android_with_kotlin.dialogboxes.AlertDialogBoxActivity
import com.example.android_with_kotlin.intents.ImplicitIntentActivity
import com.example.android_with_kotlin.list_views.CustomListViewActivity
import com.example.android_with_kotlin.list_views.ListView1Activity
import com.example.android_with_kotlin.multiple_intents_class.CafeMainActivity
import com.example.android_with_kotlin.practice.ListViewPractice
import com.example.android_with_kotlin.recyclerView.MainReViewActivity
import com.example.android_with_kotlin.uiux.ShowLogoActivity
import com.example.android_with_kotlin.viewbinding.ViewBindingActivity
import com.example.android_with_kotlin.views.WebViewActivity
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layout = findViewById<LinearLayout>(R.id.LinearLayout)
        Log.i("INFO TAG","THIS IS MY INFO TAG")
        binding.btnRead.setOnClickListener {
            layout.setBackgroundResource(R.color.yellow)
        }

        binding.btnDark.setOnClickListener {
            layout.setBackgroundResource(R.color.black)
        }
        binding.btnClickme.setOnClickListener {
           val  intent  = Intent(this, second_activity::class.java)
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
       binding.btnImplicitIntent.setOnClickListener {
           val intent =  Intent(this, ImplicitIntentActivity::class.java)
           startActivity(intent)
       }
        binding.btnWebView.setOnClickListener {
            val  intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
        binding.btnMulIntent.setOnClickListener {
            val intent = Intent(this, CafeMainActivity::class.java)
            startActivity(intent)
        }
        binding.btnUiUx.setOnClickListener {
            val intent = Intent(this, ShowLogoActivity::class.java)
            startActivity(intent)
        }
        binding.btnDataBase.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnViewBinding.setOnClickListener {
            val intent = Intent(this, ViewBindingActivity::class.java)
            startActivity(intent)
        }
        binding.btnDialogBoxes.setOnClickListener {
            val intent = Intent(this, AlertDialogBoxActivity::class.java)
            startActivity(intent)
        }
        binding.btnCustomDialog.setOnClickListener {
            val intent = Intent(this, CDMainActivity::class.java)
            startActivity(intent)
        }
        binding.btnDynamicPhotoFrame.setOnClickListener {
            val intent = Intent(this, FrameActivity::class.java)
            startActivity(intent)
        }
        binding.btnListView1.setOnClickListener {
            val intent  = Intent(this, ListView1Activity::class.java)
            startActivity(intent)
        }
        binding.btnCustomListView.setOnClickListener {
            val intent = Intent(this, CustomListViewActivity::class.java)
            startActivity(intent)
        }
        binding.btnRecyclerView.setOnClickListener {
            val intent = Intent(this, MainReViewActivity::class.java)
            startActivity(intent)
        }
        binding.btnPractice.setOnClickListener {
            val intent = Intent(this, ListViewPractice::class.java)
            startActivity(intent)
        }

    }
}