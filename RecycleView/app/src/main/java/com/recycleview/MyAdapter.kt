package com.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var playerList: ArrayList<PlayerModel>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        lateinit var playerName: TextView
        lateinit var playerImg: ImageView

        init {
            playerImg = view.findViewById(R.id.playerImg)
            playerName = view.findViewById(R.id.playerName)

            view.setOnClickListener(){
                Toast.makeText(view.context, playerList[adapterPosition]
                    .name, Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_card, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.playerName.setText(playerList[position].name)
        holder.playerImg.setImageResource(playerList[position].image)
    }
}