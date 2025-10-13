package com.example.android_with_kotlin.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android_with_kotlin.R
import com.example.android_with_kotlin.fragments.ui.login.LoginFragment

class FragmentMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment_main)
        val buttonClock = findViewById<Button>(R.id.btnClock)
        val buttonExam = findViewById<Button>(R.id.btnCxam)
        val buttonValidate = findViewById<Button>(R.id.btnValidate)
        buttonClock.setOnClickListener {
            replaceFrameWithFragment(Clock_Fragment())
        }
        buttonExam.setOnClickListener {
            replaceFrameWithFragment(Exam_Fragment())
        }
        buttonValidate.setOnClickListener {
            replaceFrameWithFragment(LoginFragment())
        }
    }
    private fun replaceFrameWithFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransation = fragmentManager.beginTransaction()
        fragmentTransation.replace(R.id.FregmentFrameLayout,fragment)
        fragmentTransation.commit()
    }
}