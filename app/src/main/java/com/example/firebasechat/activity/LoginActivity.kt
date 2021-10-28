package com.example.firebasechat.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firebasechat.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        auth= FirebaseAuth.getInstance()

        var etEmail =findViewById<EditText>(R.id.etEmail)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var btnLogin= findViewById<Button>(R.id.btnLogin)
       var btnSignUp = findViewById<Button>(R.id.btnSignUp)

       btnLogin.setOnClickListener{

            var Email = etEmail.text.toString()
            val Password = etPassword.text.toString()

            if (TextUtils.isEmpty(Email) && TextUtils.isEmpty(Password))
            {
                Toast.makeText(applicationContext, "Email or Password are required", Toast.LENGTH_SHORT).show()
            }
                 else{
                auth.signInWithEmailAndPassword(Email,Password)
                    .addOnCompleteListener {
                    if (it.isSuccessful)
                    {
                        etEmail.setText("")
                        etPassword.setText("")
                        val intent = Intent(this@LoginActivity, UsersActivity::class.java)
                        startActivity(intent)
                    }else
                    {
                        Toast.makeText(applicationContext, "Email or Password are invalid", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        btnSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        }




    }
}