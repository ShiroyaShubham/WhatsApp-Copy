package com.example.whatsappcopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class PersonalChatActivity : AppCompatActivity() {
    var dp=0
    lateinit var name:String
    lateinit var imgBack:ImageView
    lateinit var imgDP:CircleImageView
    lateinit var txtName:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_chat)

        initView()
    }

    private fun initView() {
        imgBack=findViewById(R.id.imgBack)
        if(intent!=null){
            dp=intent.getIntExtra("dp",dp)
            name= intent.getStringExtra("name").toString()
        }

        imgDP=findViewById(R.id.imgDP)
        txtName=findViewById(R.id.txtName)

        imgBack.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}