package com.example.whatsappcopy

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.whatsappcopy.fragment.CallFragment
import com.example.whatsappcopy.fragment.ChatFragment
import com.example.whatsappcopy.fragment.StatusFragment

class TabLayoutAdapter(supportFragmentManager: FragmentManager,var tabCount: Int) : FragmentPagerAdapter(supportFragmentManager,tabCount) {
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ChatFragment()
            }
            1 -> {
                return StatusFragment()
            }
            2 -> {
                return CallFragment()
            }
            else -> ChatFragment()
        }
    }
}