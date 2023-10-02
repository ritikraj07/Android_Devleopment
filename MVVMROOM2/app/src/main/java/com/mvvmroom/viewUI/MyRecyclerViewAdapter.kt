package com.mvvmroom.viewUI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvvmroom.R
import com.mvvmroom.databinding.CardItemBinding
import com.mvvmroom.room.User

class MyRecyclerViewAdapter(
    private val userList:List<User>,
    private val clickListener: (User)->Unit
): RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardItemBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.card_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position], clickListener)
    }

}

class MyViewHolder(val binding: CardItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(user: User, clickListener: (User) -> Unit){
        binding.nameTextView.text = user.name
        binding.emailTextView.text = user.email
        binding.listItemLayout.setOnClickListener(){
            clickListener(user)
        }
    }

}