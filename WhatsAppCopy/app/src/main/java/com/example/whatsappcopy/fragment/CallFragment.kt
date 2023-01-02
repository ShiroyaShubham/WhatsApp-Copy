package com.example.whatsappcopy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappcopy.CallListAdapter
import com.example.whatsappcopy.R
import com.example.whatsappcopy.StatusListModel

class CallFragment : Fragment() {
    lateinit var v:View
    lateinit var rcvCallList: RecyclerView
    var status : ArrayList<Int> = ArrayList()
    var name : ArrayList<String> = ArrayList()
    var time : ArrayList<String> = ArrayList()
    var callList : ArrayList<StatusListModel> = ArrayList()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v=inflater.inflate(R.layout.fragment_call, container, false)
        initView()
        listing()
        return v
    }


    private fun listing() {
        status.add(R.drawable.markzukerberg)
        status.add(R.drawable.bill_gates)
        status.add(R.drawable.elon_musk)
        status.add(R.drawable.satya_nandela)
        status.add(R.drawable.steve_jobs)
        status.add(R.drawable.warren_buffet)
        status.add(R.drawable.sunder_pichie)
        status.add(R.drawable.gautam_adani)
        status.add(R.drawable.mukesh_ambani)

        name.add("Mark Zukerberg")
        name.add("Bill Gates")
        name.add("Elon Musk")
        name.add("Satya Nadella")
        name.add("Steve Jobs")
        name.add("Warren Buffet")
        name.add("Sunder Pichie")
        name.add("Gautam Adani")
        name.add("Mukesh Ambani")

        time.add("20 minute ago")
        time.add("47 minute ago")
        time.add("Today,11:13 PM")
        time.add("Today,2:07 PM")
        time.add("Today,9:11 PM")
        time.add("Yesterday,7:30 AM")
        time.add("Yesterday,8:23 PM")
        time.add("Yesterday,4:23 PM")
        time.add("Yesterday,6:23 PM")

        for(i in 0..8){
            val model= StatusListModel(status.get(i),name.get(i), time.get(i))
            callList.add(model)
        }

    }

    private fun initView() {
        rcvCallList = v.findViewById(R.id.rcvCallList)
        val callListAdapter = CallListAdapter(callList)
        val manager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rcvCallList.layoutManager = manager
        rcvCallList.adapter = callListAdapter

    }
}