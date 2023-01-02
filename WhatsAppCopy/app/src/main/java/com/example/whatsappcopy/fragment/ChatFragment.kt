package com.example.whatsappcopy.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappcopy.*


class ChatFragment : Fragment() {
    lateinit var v: View
    lateinit var rcvChatList: RecyclerView
    lateinit var loutContact: LinearLayout
    var dp: ArrayList<Int> = ArrayList()
    var name: ArrayList<String> = ArrayList()
    var lastChat: ArrayList<String> = ArrayList()
    var time: ArrayList<String> = ArrayList()
    var chatList: ArrayList<ChatListModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_chat, container, false)
        initView()
        listing()
        return v
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


        lastChat.add("Introducing IGTV on instagram!!")
        lastChat.add("Tried Linux and I loved it")
        lastChat.add("Gotta add a pinch on ML in every single tech")
        lastChat.add("You need some funding?")
        lastChat.add("finally,switching to Android..")
        lastChat.add("I,m the richest in the list")
        lastChat.add("Alexa, sucks! Google Assistant is the boss!")
        lastChat.add("You need some funding?")
        lastChat.add("Gotta add a pinch on ML in every single tech")

        time.add("9:11 PM")
        time.add("4:40 PM")
        time.add("11:13 PM")
        time.add("2:07 PM")
        time.add("9:11 PM")
        time.add("7:30 AM")
        time.add("8:23 PM")
        time.add("9:53 PM")
        time.add("10:39 PM")

        for (i in 0..8) {
            val model = ChatListModel(dp.get(i), name.get(i), lastChat.get(i), time.get(i))
            chatList.add(model)
        }

    }

    private fun initView() {
        rcvChatList = v.findViewById(R.id.rcvChatList)
        loutContact = v.findViewById(R.id.loutContact)

        var onClikChatBoxInterface = object : OnClikChatBoxInterface {
            override fun onClick() {
                val chatIntent = Intent(activity, PersonalChatActivity::class.java)
                chatIntent.putExtra("dp",dp)
                chatIntent.putExtra("name",name)
                startActivity(chatIntent)
            }
        }


        val chatListAdapter = ChatListAdapter(chatList,onClikChatBoxInterface)
        val manager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rcvChatList.layoutManager = manager
        rcvChatList.adapter = chatListAdapter

        loutContact.setOnClickListener{

            val intent = Intent(activity, ContactActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }
}


