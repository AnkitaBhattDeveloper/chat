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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.String as String

class SignupActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        //Toast.makeText(this.applicationContext, "welcome", Toast.LENGTH_SHORT).show()
        auth = FirebaseAuth.getInstance()

      val btnSignUp: Button = findViewById(R.id.btnSignup)
        val etName: EditText = findViewById(R.id.etName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etConfirmPassword: EditText = findViewById(R.id.etConfirmPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)


        btnSignUp.setOnClickListener {
            val userName = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()


            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "email required", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(userName)) {
                Toast.makeText(applicationContext, "user name required", Toast.LENGTH_SHORT).show()
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(applicationContext, "password required", Toast.LENGTH_SHORT).show()
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(applicationContext, "Re-type your password", Toast.LENGTH_SHORT)
                    .show()

            }
            registerUser(userName, email, password)
        }

        btnLogin.setOnClickListener {
            intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun registerUser(userName: String="", email: String="", password: String="") {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user: FirebaseUser? = auth.currentUser
                    val userId: String = user!!.uid
                    databaseReference =
                        FirebaseDatabase.getInstance().getReference("Users").child(userId)

                    val hashMap: HashMap<String, String> = HashMap()
                    hashMap.put("userID", userId)
                    hashMap.put("userName", userName)
                    hashMap.put("profile Image", "")

                    databaseReference.setValue(hashMap).addOnCompleteListener(this)
                    {

                        if (it.isSuccessful) {



                            intent = Intent(this@SignupActivity, UsersActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
    }
}


