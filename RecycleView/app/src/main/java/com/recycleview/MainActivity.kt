package com.recycleview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recycleView: RecyclerView = findViewById(R.id.recycleView)

//

//        recycleView.layoutManager = LinearLayoutManager(this,
//            LinearLayoutManager.VERTICAL,
//            false
//        )
//        val myAdapter = MyRecycleAdapter(GetPlayers())
//        recycleView.adapter = myAdapter


        recycleView.layoutManager = LinearLayoutManager(this)
        var adapter = MyAdapter2(GetPlayers())
        recycleView.adapter = adapter

    }
    fun GetPlayers(): ArrayList<PlayerModel>{
        var players: ArrayList<PlayerModel> = ArrayList()

        var p1 = PlayerModel("Sehwag", R.drawable.sehwag)
        var p2 = PlayerModel("Yuraj", R.drawable.yuraj)
        var p3 = PlayerModel("virat", R.drawable.virat)
        var p4 = PlayerModel("Hardik", R.drawable.hardik)
        var p5 = PlayerModel("Rahul", R.drawable.rahul)

        players.add(p1)
        players.add(p2)
        players.add(p3)
        players.add(p4)
        players.add(p5)

        players.add(p1)
        players.add(p2)
        players.add(p3)
        players.add(p4)
        players.add(p5)

        return players
    }
}