package com.example.libarayapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent = Intent(this, RegisterActivity::class.java)
        val intent2 = Intent(this, HomeActivity::class.java)
        val text: TextView =findViewById(R.id.goToSignUp)
        val emailEditText: EditText?=findViewById(R.id.editText)
        val passwordEditText: EditText?=findViewById(R.id.editText2)
        val button:Button=findViewById(R.id.button)
        text.setOnClickListener()
        {
            startActivity(intent)
        }
        button.setOnClickListener()
        {
            if (emailEditText?.text.isNullOrEmpty())
            {
                Toast.makeText(this,"enter your Email",Toast.LENGTH_SHORT).show()
            }
            if (passwordEditText?.text.isNullOrEmpty())
            {
                Toast.makeText(this,"enter your Password",Toast.LENGTH_SHORT).show()
            }
            else {
                val email: String = emailEditText?.text.toString()
                val password: String = passwordEditText?.text.toString()
                val auth = Firebase.auth
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            startActivity(intent2)


                        } else {

                            Log.w(ContentValues.TAG, "Login :failure", task.exception)
                            Toast.makeText(
                                baseContext,
                                task.exception?.message ?: "An error occurred",
                                Toast.LENGTH_SHORT,
                            ).show()

                        }
                    }
            }
        }
    }
}