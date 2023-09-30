package com.tablayout.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tablayout.Fragment.FragmentOne
import com.tablayout.Fragment.FragmentThird
import com.tablayout.Fragment.FragmentTwo

class MyAdapter(Fragmentmanger: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(Fragmentmanger, lifecycle) {
    override fun getItemCount(): Int {
        return 3
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
                return FragmentThird()
            }
        }
        return FragmentOne()
    }
}