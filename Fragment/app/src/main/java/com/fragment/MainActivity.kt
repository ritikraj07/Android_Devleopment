package com.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btm1: Button = findViewById(R.id.btm1)
        var btm2: Button = findViewById(R.id.btm2)


        btm1.setOnClickListener(){
            var fragment1:Fragment1 = Fragment1()
            var framTran: FragmentTransaction = supportFragmentManager.beginTransaction()
            framTran.replace(R.id.frame1, fragment1).commit()
        }

        btm2.setOnClickListener(){
            var fragment2: Fragment2 = Fragment2()
            var fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame2, fragment2).commit()
        }

    }
}