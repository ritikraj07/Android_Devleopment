package com.pageviewer.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pageviewer.Fragment.FragmentOne
import com.pageviewer.Fragment.FragmentThree
import com.pageviewer.Fragment.FragmentTwo
import com.pageviewer.MainActivity

class MyAdapter(mainActivity: MainActivity): FragmentStateAdapter(mainActivity) {

    private val fragmentNum = 3
    override fun getItemCount(): Int {
        return fragmentNum
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{
                return FragmentOne()
            }
            1->{
                return FragmentTwo()
            }
            2->{
                return FragmentThree()
            }
        }
        return FragmentOne()
    }

}