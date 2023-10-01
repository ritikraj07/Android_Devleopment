package com.onlylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.onlylivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModelLiveData: ViewModelLiveData
    lateinit var factory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        factory = ViewModelFactory(100)
        viewModelLiveData = ViewModelProvider(this, factory).get(ViewModelLiveData::class.java)

        var count: Int = 0

        viewModelLiveData.totalSum.observe(
            this,
            Observer {
                binding.counterTxt.text = it.toString()
            }
        )

        binding.addCustomBtm.setOnClickListener(){
            viewModelLiveData.AddInput(binding.startsInput.text.toString().toInt())
        }

//        binding.apply {
//            addBtm.setOnClickListener(){
//                viewModelLiveData.AddTen()
//              counterTxt.setText(viewModelLiveData.totalSum.value.toString())
//            }
//        }
        binding.viewModel = viewModelLiveData
    }
}