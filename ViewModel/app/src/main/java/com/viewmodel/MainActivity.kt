package com.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myViewModel: MainActivityViewModel
    lateinit var factory: MainActivityViewModeFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        factory = MainActivityViewModeFactory(100)

//        while not using factory
//        myViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // while using factory
        myViewModel = ViewModelProvider(this, factory)
            .get(MainActivityViewModel::class.java)

        binding.apply {
            counterText.text = myViewModel.GetCount().toString()
            btm.setOnClickListener(){
                counterText.text = myViewModel.IncreaseCount().toString()
            }
        }


    }
}