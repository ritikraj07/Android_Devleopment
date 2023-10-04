package com.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var count: Int = 0
        binding.countBtm.setOnClickListener(){
            // main thread
            CoroutineScope(Dispatchers.Main).launch {
                binding.counterText.text = count++.toString()
            }

        }

//        binding.downloadBtm.setOnClickListener(){
//             background thread
//            CoroutineScope(Dispatchers.IO).launch {
//                download()
//            }
//
//        }

        var num1:Int
        var num2:Int


        //sequential order coroutine
//        CoroutineScope(Dispatchers.Main).launch{
//            num1 = firstNum()
//            num2 = secondNum()
//            binding.addBtm.setOnClickListener(){
//                binding.sumText.text = (num1+num2).toString()
//            }
//        }


        // paraller order coroutine
        CoroutineScope(Dispatchers.IO).launch {
           var n1 =  async{firstNum()}
            var n2 = async { secondNum() }
            var sum = n1.await() + n2.await()
            Log.v("tagy", "sum is $sum")
            binding.sumText.text = sum.toString()
        }


    }
    suspend fun download(){
        for(i in 1..1000){
//            Log.v("tagy", "download $i")
            withContext(Dispatchers.Main){
                binding.downloadText.text = i.toString()
            }

        }
    }


    suspend fun firstNum():Int{
        Log.v("tagy", "first started")
        delay(5000)
        Log.v("tagy", "first done")

        return 10

    }

    suspend fun secondNum():Int{
        Log.v("tagy", "second started")
        delay(10000)
        Log.v("tagy", "second done")
        return 5
    }
}