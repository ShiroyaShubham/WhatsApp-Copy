package com.example.whatsappcopy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ChatListAdapter(var chatList: ArrayList<ChatListModel>,var onClikChatBoxInterface: OnClikChatBoxInterface) : RecyclerView.Adapter<ChatListAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgDP = itemView.findViewById<CircleImageView>(R.id.imgDP)
        var txtName = itemView.findViewById<TextView>(R.id.txtName)
        var txtLastChat = itemView.findViewById<TextView>(R.id.txtLastChat)
        var txtTime = itemView.findViewById<TextView>(R.id.txtTime)
        var loutChatBox = itemView.findViewById<LinearLayout>(R.id.loutChatBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.chat_list_item, parent, false)
        var myViewHolder = MyViewHolder(v)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imgDP.setImageResource(chatList[position].dp)
        holder.txtName.setText(chatList[position].name)
        holder.txtLastChat.setText(chatList[position].lastChat)
        holder.txtTime.setText(chatList[position].time)
        holder.loutChatBox.setOnClickListener {
            onClikChatBoxInterface.onClick()
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}