package com.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tablayout.Adapter.MyAdapter

class MainActivity : AppCompatActivity() {
    var tabArray = arrayOf("Tab1", "Tab2", "Tab3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewPager2: ViewPager2 = findViewById(R.id.viewPager2)
        var tabLayout: TabLayout = findViewById(R.id.tabLayout)

        var adapter = MyAdapter(supportFragmentManager, lifecycle )

        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2){
            tab, position -> tab.text = tabArray[position]
        }.attach()

    }
}