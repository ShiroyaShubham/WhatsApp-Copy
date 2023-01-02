package com.example.whatsappcopy


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.whatsappcopy.fragment.SearchFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var imgSearch : ImageView
    var i=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun loadFragment(fragment: Fragment) {
        val fm:FragmentManager=supportFragmentManager
        val fragmentTransaction : androidx.fragment.app.FragmentTransaction = fm.beginTransaction()

        fragmentTransaction.replace(R.id.container,fragment,"Hello")
        fragmentTransaction.commit()
    }


    private fun initView() {
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.ViewPager)
        imgSearch = findViewById(R.id.imgSearch)

        imgSearch.setOnClickListener{
            if(i%2==0) {
                var searchFragment = SearchFragment()
                loadFragment(searchFragment)
            }
            else
            {
                var fragment=Fragment()
                loadFragment(fragment)
            }
            i++;
            var tabLayoutAdapter = TabLayoutAdapter(supportFragmentManager, tabLayout.tabCount)
            viewPager.adapter = tabLayoutAdapter

        }

        tabLayout.addTab(tabLayout.newTab().setText("CHATS"))
        tabLayout.addTab(tabLayout.newTab().setText("STATUS"))
        tabLayout.addTab(tabLayout.newTab().setText("CALLS"))

        var tabLayoutAdapter = TabLayoutAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = tabLayoutAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
            viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}