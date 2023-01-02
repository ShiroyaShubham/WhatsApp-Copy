package com.example.whatsappcopy.fragment

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappcopy.*
import java.lang.reflect.Type

class StatusFragment : Fragment() {
    lateinit var v: View
    lateinit var rcvStatusList: RecyclerView
    lateinit var loutCamera: LinearLayout
    lateinit var loutAddStatus: LinearLayout
    lateinit var loutPencil: LinearLayout
    var status: ArrayList<Int> = ArrayList()
    var name: ArrayList<String> = ArrayList()
    var time: ArrayList<String> = ArrayList()
    var statusList: ArrayList<StatusListModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_status, container, false)
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
        time.add("Yesterday8:23 PM")
        time.add("Yesterday,4:23 PM")
        time.add("Yesterday,6:23 PM")

        for (i in 0..8) {
            val model = StatusListModel(status.get(i), name.get(i), time.get(i))
            statusList.add(model)
        }
    }

    private fun initView() {
        rcvStatusList = v.findViewById(R.id.rcvStatusList)
        loutCamera = v.findViewById(R.id.loutCamera)
        loutAddStatus = v.findViewById(R.id.loutAddStatus)
        loutPencil = v.findViewById(R.id.loutPencil)
        val statusListAdapter = StatusListAdapter(statusList)
        val manager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rcvStatusList.layoutManager = manager
        rcvStatusList.adapter = statusListAdapter

        loutCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 100)
        }

        loutAddStatus.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 100)
        }

        loutPencil.setOnClickListener {
            val pencilIntent=Intent(activity,TypeAStatusActivity::class.java)
            startActivity(pencilIntent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100)
        {
            if(resultCode==-1 && data!=null)
                {
                    val photo:Bitmap= data.extras?.get("data")as Bitmap

                }
            else
            {

            }
        }
        else{
            Toast.makeText(requireActivity(), "something went wrong", Toast.LENGTH_SHORT).show()
        }
    }

}