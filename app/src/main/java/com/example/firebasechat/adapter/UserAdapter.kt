package com.example.firebasechat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firebasechat.R
import com.example.firebasechat.model.User
import de.hdodenhof.circleimageview.CircleImageView


class UserAdapter(private val context:Context,private val userList:ArrayList<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
  val user = userList[position]
        holder.txtuserName.text = user.userName
        Glide.with(context).load(user.userImage).into(holder.imageUser)
    }


    override fun getItemCount(): Int {
       return userList.size
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val txtuserName:TextView =view.findViewById(R.id.userName)
        val txttemp:TextView=view.findViewById(R.id.temp)
        val imageUser:CircleImageView=view.findViewById(R.id.userImage)





    }

}