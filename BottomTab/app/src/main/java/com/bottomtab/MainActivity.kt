package com.bottomtab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.ButtonBarLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bottomtab.bottom_screens.Home
import com.bottomtab.bottom_screens.Liked
import com.bottomtab.bottom_screens.Profile
import com.bottomtab.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//
        var fragTras = supportFragmentManager.beginTransaction()
        fragTras.replace(R.id.container, Home() ).commit()




        binding.bottomNav.setOnItemSelectedListener(){
            when(it.itemId){
                R.id.home_tab -> {
                    replaceFragment(Home())
                }
                R.id.liked_tab->{
                    replaceFragment(Liked())
                }
                R.id.profile_tab->{
                    replaceFragment(Profile())
                }
            }
            true
        }


    }
    private fun replaceFragment(fragment: Fragment){
        var fragementManager = supportFragmentManager
        var fragementTrans = fragementManager.beginTransaction()
        fragementTrans.replace(R.id.container, fragment)
        fragementTrans.commit()
    }
}