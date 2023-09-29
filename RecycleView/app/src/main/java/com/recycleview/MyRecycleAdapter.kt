package com.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecycleAdapter(var players: ArrayList<PlayerModel>)
    : RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder>() {

        inner class MyViewHolder(player: View): RecyclerView.ViewHolder(player){
             var playerName: TextView
             var playerImg: ImageView

            init {
                playerName = player.findViewById(R.id.playerName)
                playerImg = player.findViewById(R.id.playerImg)

                player.setOnClickListener(){
                    Toast.makeText(player.context, "${players[adapterPosition].name}", Toast.LENGTH_LONG).show()
                }
            }


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_card, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.playerName.setText(players[position].name)
        holder.playerImg.setImageResource(players[position].image)
    }
}