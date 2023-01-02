package com.example.whatsappcopy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappcopy.fragment.ContactListModel

class ContactListAdapter(var contactList: ArrayList<ContactListModel>) : RecyclerView.Adapter<ContactListAdapter.MyViewHolder>() {
    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var imgDp=itemView.findViewById<ImageView>(R.id.imgDP)
        var txtName=itemView.findViewById<TextView>(R.id.txtName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        var myViewHolder=MyViewHolder(view)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imgDp.setImageResource(contactList.get(position).dp)
        holder.txtName.setText(contactList.get(position).name)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}