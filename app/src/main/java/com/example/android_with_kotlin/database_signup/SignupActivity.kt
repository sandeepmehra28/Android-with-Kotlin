package com.example.android_with_kotlin.database_signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_with_kotlin.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    // late init var means declare first and then assign value after
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
       val signBtn = findViewById<Button>(R.id.Btn)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val etPass = findViewById<TextInputEditText>(R.id.etPass)
        val etUserId = findViewById<TextInputEditText>(R.id.etUserId)
        val switchReg = findViewById<TextView>(R.id.RegBtn)
        switchReg.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }
      signBtn.setOnClickListener {
          val name =  etName.text.toString()
          val mail = etMail.text.toString()
          val pass = etPass.text.toString()
          val userId = etUserId.text.toString()
              val user = Users(name,mail,pass,userId)
           database = FirebaseDatabase.getInstance().getReference("Users")
              database.child(userId).setValue(user).addOnSuccessListener {
                  Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
              }.addOnSuccessListener {
                  Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show() }
      }

    }
}