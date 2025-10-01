package com.example.android_with_kotlin.dialogboxes

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R
import com.example.android_with_kotlin.databinding.ActivityAlertDialogBoxBinding

class AlertDialogBoxActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlertDialogBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertDialogBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure")
            builder1.setMessage("Do you want to close the app")
            builder1.setIcon(R.drawable.exit_icon)
            builder1.setPositiveButton("YES", DialogInterface.OnClickListener{dialogInterface, i ->
                finish()
            })
            builder1.setNegativeButton("NO", DialogInterface.OnClickListener{dialogInterface, i ->

            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("java","php","python","C++","c","js")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("which language do you know")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener{dialogInterface, i ->
                Toast.makeText(this, "you clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener{dialogInterface, i ->

            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener{dialogInterface, i ->

            })
            builder2.show()
        }
        binding.btn3.setOnClickListener {
            val options = arrayOf("java","php","python","C++","c","js")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("which language do you know")
            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this, "you clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener{dialogInterface, i ->

            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener{dialogInterface, i ->

            })
            builder3.show()
        }
    }
}