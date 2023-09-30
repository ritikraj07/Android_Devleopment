package com.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btm.setOnClickListener(){
            Toast.makeText(this, "Yo Toast", Toast.LENGTH_LONG).show()
        }

        var user1 = DataModel("Ritik", "20")
        binding.user=user1
    }
}