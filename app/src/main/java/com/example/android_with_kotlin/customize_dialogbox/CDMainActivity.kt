package com.example.android_with_kotlin.customize_dialogbox

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R

class CDMainActivity : AppCompatActivity() {
    lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cd_main)
        val clickbtn = findViewById<Button>(R.id.clickMeBtn)
        clickbtn.setOnClickListener {
            dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_dialog))

            // Find dialog buttons after dialog is set up
            val goodBtn = dialog.findViewById<Button>(R.id.GoodBtn)
            val feedbackBtn = dialog.findViewById<Button>(R.id.FeedbackBtn)

            goodBtn.setOnClickListener {
                dialog.dismiss()
            }

            feedbackBtn.setOnClickListener {
                dialog.dismiss()

            }

            dialog.show()
        }

    }
}