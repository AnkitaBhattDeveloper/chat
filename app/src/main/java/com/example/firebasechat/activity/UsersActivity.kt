package com.example.firebasechat.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasechat.R
import com.example.firebasechat.adapter.UserAdapter
import com.example.firebasechat.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class UsersActivity : AppCompatActivity()

{   lateinit var userRecyclerView:RecyclerView
    var userList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)



        val userRecyclerView=findViewById<RecyclerView>(R.id.userRecyclerView)
        userRecyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))
//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))
//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))
//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))
//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))
//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))
//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))
//        userList.add(User("Ankita","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd6vp_1wkyH_s2NhWlFHQEN69LeUSggGJerw&usqp=CAU"))

      getUsersList()

    }
    fun getUsersList()
    {
        val firebase:FirebaseUser= FirebaseAuth.getInstance().currentUser!!
        val databaseReference:DatabaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.addValueEventListener(object :ValueEventListener
        {

            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()

                for(dataSnapShot:DataSnapshot in snapshot.children)
                {
                     var user =dataSnapShot.getValue(User::class.java)

                    if (user!!.userId.equals(firebase.uid))
                    {
                        userList.add(user)
                    }

                }

                var userAdapter= UserAdapter(this,userList)
                userRecyclerView.adapter=userAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }


        })

    }


}
