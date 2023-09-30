package com.pageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.pageviewer.Adapter.MyAdapter

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    lateinit var arraylist: ArrayList<Int>
    lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2 = findViewById(R.id.viewPager2)
        adapter = MyAdapter(this)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.adapter = adapter

    }
}