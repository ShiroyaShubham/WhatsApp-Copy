package com.example.whatsappcopy

import android.R.attr
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappcopy.fragment.ContactListModel
import com.example.whatsappcopy.fragment.SearchFragment


class ContactActivity : AppCompatActivity() {
    private var pick_Contact=101
    lateinit var rcvContactList:RecyclerView
    lateinit var imgBack:ImageView
    lateinit var loutAddContact:LinearLayout
    lateinit var loutNewGroup:LinearLayout
    lateinit var imgSearch : ImageView
    var dp : ArrayList<Int> = ArrayList()
    var name : ArrayList<String> = ArrayList()
    var contactList : ArrayList<ContactListModel> = ArrayList()
    var i=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        listing()
        initView()
    }

    private fun initView() {
        imgBack=findViewById(R.id.imgBack)
        rcvContactList=findViewById(R.id.rcvContactList)
        loutAddContact=findViewById(R.id.loutAddContact)
        loutNewGroup=findViewById(R.id.loutNewGroup)
        imgSearch = findViewById(R.id.imgSearch)
        val contactListAdapter=ContactListAdapter(contactList)
        val manager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rcvContactList.adapter=contactListAdapter
        rcvContactList.layoutManager=manager

        imgBack.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        loutAddContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent, pick_Contact)
        }

        loutNewGroup.setOnClickListener {
            val newGroupIntent=Intent(this,NewGroupActivity::class.java)
            startActivity(newGroupIntent)
            finish()
        }

        imgSearch.setOnClickListener {
            if(i%2==0){
                var searchFragment=SearchFragment()
                loadFragment(searchFragment)
            }
            else
            {
              var fragment=Fragment()
                  loadFragment(fragment)
            }
            i++
            val contactListAdapter=ContactListAdapter(contactList)
            val manager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            rcvContactList.adapter=contactListAdapter
            rcvContactList.layoutManager=manager
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

        name.add("Mark Zukerberg")
        name.add("Bill Gates")
        name.add("Elon Musk")
        name.add("Satya Nadella")
        name.add("Steve Jobs")
        name.add("Warren Buffet")
        name.add("Sunder Pichie")
        name.add("Gautam Adani")
        name.add("Mukesh Ambani")

        for(i in 0..8){
            val model=ContactListModel(dp.get(i),name.get(i))
            contactList.add(model)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fm: FragmentManager =supportFragmentManager
        val fragmentTransaction : androidx.fragment.app.FragmentTransaction = fm.beginTransaction()

        fragmentTransaction.replace(R.id.ContainerContact,fragment,"Hello")
        fragmentTransaction.commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
        pick_Contact-> if (resultCode === RESULT_OK) {
                val contactData: Uri? = data?.data
                val c: Cursor = managedQuery(contactData, null, null, null, null)
                if (c.moveToFirst()) {
                    val name: String =
                        c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    // TODO Fetch other Contact details as you want to use
                }
            }
        }
    }
}