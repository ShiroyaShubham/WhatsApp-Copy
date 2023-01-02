package com.example.whatsappcopy


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class StatusListAdapter(var statusList: ArrayList<StatusListModel>) : RecyclerView.Adapter<StatusListAdapter.MyViewHolder>() {
    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var imgStatus=itemView.findViewById<CircleImageView>(R.id.imgStatus)
        var txtName=itemView.findViewById<TextView>(R.id.txtName)
        var txtTime=itemView.findViewById<TextView>(R.id.txtTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v:View=LayoutInflater.from(parent.context).inflate(R.layout.status_list_item,parent,false)
        var myViewHolder=MyViewHolder(v)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imgStatus.setImageResource(statusList[position].status)
        holder.txtName.setText(statusList[position].name)
        holder.txtTime.setText(statusList[position].time)
    }

    override fun getItemCount(): Int {
        return statusList.size
    }
}