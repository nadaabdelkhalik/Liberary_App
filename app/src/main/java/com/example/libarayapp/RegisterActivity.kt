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

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val intent = Intent(this, LoginActivity::class.java)
        val intent2 = Intent(this, HomeActivity::class.java)
        val button: Button =findViewById(R.id.button)
        val text: TextView =findViewById(R.id.goToLogin)
        val nameEditText: EditText?=findViewById(R.id.editText)
        val emailEditText: EditText?=findViewById(R.id.editText2)
        val passwordEditText: EditText?=findViewById(R.id.editText3)
        val confirmPasswordEditText: EditText?=findViewById(R.id.editText4)

        text.setOnClickListener()
        {
            startActivity(intent)
        }
        button.setOnClickListener()
        {
            if(nameEditText?.text.isNullOrEmpty())
            {
                Toast.makeText(this,"enter your Email",Toast.LENGTH_SHORT).show()
            }

            if (emailEditText?.text.isNullOrEmpty())
            {
                Toast.makeText(this,"enter your Email",Toast.LENGTH_SHORT).show()
            }
            if (passwordEditText?.text.isNullOrEmpty())
            {
                Toast.makeText(this,"enter your Password",Toast.LENGTH_SHORT).show()
            }
            if(confirmPasswordEditText?.text.isNullOrEmpty())
            {
                Toast.makeText(this,"confirm your Password",Toast.LENGTH_SHORT).show()
            }


            else {
                val email: String = emailEditText?.text.toString()
                val password: String = passwordEditText?.text.toString()
                val auth = Firebase.auth

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            startActivity(intent2)


                        } else {

                            Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
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