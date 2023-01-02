package com.example.whatsappcopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappcopy.fragment.ContactListModel
import com.example.whatsappcopy.fragment.SearchFragment

class NewGroupActivity : AppCompatActivity() {
    lateinit var rcvContactList: RecyclerView
    lateinit var imgBack: ImageView
    lateinit var imgSearch : ImageView
    var i=0

    var dp : ArrayList<Int> = ArrayList()
    var name : ArrayList<String> = ArrayList()
    var contactList : ArrayList<ContactListModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_group)
        listing()
        initView()
    }

    private fun initView() {
        imgBack=findViewById(R.id.imgBack)
        rcvContactList=findViewById(R.id.rcvContactList)
        imgSearch = findViewById(R.id.imgSearch)

        imgSearch.setOnClickListener {
            if (i % 2 == 0) {
                var searchFragment = SearchFragment()
                loadFragment(searchFragment)
            } else {
                var fragment = Fragment()
                loadFragment(fragment)
            }
            i++;
        }

        val contactListAdapter=ContactListAdapter(contactList)
        val manager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true)
        rcvContactList.adapter=contactListAdapter
        rcvContactList.layoutManager=manager

        imgBack.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun listing() {
        dp.add(R.drawable.markzukerberg)
        dp.add(R.drawable.bill_gates)
        dp.add(R.drawable.elon_musk)
        dp.add(R.drawable.satya_nandela)
        dp.add(R.drawable.steve_jobs)
        dp.add(R.drawable.warren_buffet)
        dp.add(R.drawable.sunder_pichie)
        dp.add(R.drawable.gautam_adani)
        dp.add(R.drawable.mukesh_ambani)
        dp.add(R.drawable.markzukerberg)
        dp.add(R.drawable.bill_gates)
        dp.add(R.drawable.elon_musk)
        dp.add(R.drawable.satya_nandela)
        dp.add(R.drawable.steve_jobs)
        dp.add(R.drawable.warren_buffet)
        dp.add(R.drawable.sunder_pichie)
        dp.add(R.drawable.gautam_adani)
        dp.add(R.drawable.mukesh_ambani)

        name.add("Mark Zukerberg")
        name.add("Bill Gates")
        name.add("Elon Musk")
        name.add("Satya Nadella")
        name.add("Steve Jobs")
        name.add("Warren Buffet")
        name.add("Sunder Pichie")
        name.add("Gautam Adani")
        name.add("Mukesh Ambani")
        name.add("Mark Zukerberg")
        name.add("Bill Gates")
        name.add("Elon Musk")
        name.add("Satya Nadella")
        name.add("Steve Jobs")
        name.add("Warren Buffet")
        name.add("Sunder Pichie")
        name.add("Gautam Adani")
        name.add("Mukesh Ambani")

        for(i in 0..17){
            val model= ContactListModel(dp.get(i),name.get(i))
            contactList.add(model)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fm:FragmentManager=supportFragmentManager
        val fragmentTransaction : androidx.fragment.app.FragmentTransaction = fm.beginTransaction()

        fragmentTransaction.replace(R.id.GroupContainer,fragment,"Hello")
        fragmentTransaction.commit()
    }

}