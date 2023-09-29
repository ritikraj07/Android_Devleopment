 package com.mymenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

//        val array = arrayOf("India", "Bihar", "Mumbai", "Delhi", "Kolkata", "Jaipur", "Chennai")
//
//        var adapter: ArrayAdapter<String>
//
//        adapter = ArrayAdapter(
//            this, R.layout.mysimplelist, R.id.textView, array
//        )
//
//        listView.adapter = adapter

        var myadapter = WorldCupAdapter(this, GenerateArray() )

        listView.adapter = myadapter
        myadapter?.notifyDataSetChanged()





    }

     fun GenerateArray(): ArrayList<WorldCupDataModel>{
         var myArray: ArrayList<WorldCupDataModel> = ArrayList()

         var a1 = WorldCupDataModel("India", "Always wins", R.drawable.earth)
         var a2 = WorldCupDataModel("Bihar", "In Next Livel", R.drawable.jupiter)
         var a3 = WorldCupDataModel("Delhi", "Always wins", R.drawable.mercury)
         var a4 = WorldCupDataModel("Mumbai", "In Next Livel", R.drawable.uranus)
         var a5 = WorldCupDataModel("Patna", "Always wins", R.drawable.neptune)
         var a6 = WorldCupDataModel("Rachi", "In Next Livel", R.drawable.mars)
         var a7 = WorldCupDataModel("Kolkata", "Always wins", R.drawable.pluto)
         var a8 = WorldCupDataModel("Rajasthan", "In Next Livel", R.drawable.venus)

         myArray.add(a1)
         myArray.add(a2)
         myArray.add(a3)
         myArray.add(a4)
         myArray.add(a5)
         myArray.add(a6)
         myArray.add(a7)
         myArray.add(a8)

         return myArray
     }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         Toast.makeText(this, menu.toString(), Toast.LENGTH_LONG).show()
         menuInflater.inflate(R.menu.my_menu, menu)
         return true
     }
}