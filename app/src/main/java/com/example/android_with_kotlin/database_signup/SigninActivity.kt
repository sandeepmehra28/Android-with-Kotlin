package com.example.android_with_kotlin.database_signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_with_kotlin.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SigninActivity : AppCompatActivity() {
    companion object{
        const val KEY1 = "com.example.android_with_kotlin.database_signup.mail"
        const val KEY2 = "com.example.android_with_kotlin.database_signup.name"
        const val KEY3 = "com.example.android_with_kotlin.database_signup.id"
    }
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin2)
       val signinBtn = findViewById<Button>(R.id.BtnSignin)
        val userNameEditText = findViewById<TextInputEditText>(R.id.userNameEditText)
        signinBtn.setOnClickListener {
            val uniqueId = userNameEditText.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }
            else{
                Toast.makeText(this, "please enter user name", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readData(uniqueId: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {
           if(it.exists()){
               //intent or info
               val name = it.child("name").value
               val email = it.child("email").value
               val userId = it.child("uniqueID").value
               val intent = Intent(this, WelcomeActivity::class.java)
               intent.putExtra(KEY2,name.toString())
               intent.putExtra(KEY1,email.toString())
               intent.putExtra(KEY3,userId.toString())
               startActivity(intent)
           }else{
               Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
           }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }

    }
}


