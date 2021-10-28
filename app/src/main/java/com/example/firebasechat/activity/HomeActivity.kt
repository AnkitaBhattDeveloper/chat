package com.example.firebasechat.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasechat.R
import com.example.firebasechat.adapter.UserAdapter
import com.example.firebasechat.model.User
import android.widget.LinearLayout as LinearLayout

class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        Toast.makeText(applicationContext, "welcome too home page", Toast.LENGTH_SHORT).show()
//
//val userRecyclerView=findViewById<RecyclerView>(R.id.userRecyclerView)
//        userRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)
//        var userList = ArrayList<User>()
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//        userList.add(User("Ankita","https://www.pexels.com/photo/woman-under-pendant-lights-looking-at-the-photo-on-the-wall-3584992/"))
//
//        var userAdapter=UserAdapter(this,userList)
//        userRecyclerView.adapter=userAdapter
//
//
 }
    }
