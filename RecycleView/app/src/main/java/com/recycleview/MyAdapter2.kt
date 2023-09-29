package com.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MyAdapter2(var players: ArrayList<PlayerModel>)
    : RecyclerView.Adapter<MyAdapter2.MyViewHolder>()
{
    inner class MyViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.playerName)
        var image: ImageView = view.findViewById(R.id.playerImg)

        init {
            view.setOnClickListener(){
                Toast.makeText(view.context, "its ok", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_card, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.setText(players[position].name)
        holder.image.setImageResource(players[position].image)
    }
}