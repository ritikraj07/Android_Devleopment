package com.mymenu

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class WorldCupAdapter(private var activity: Activity, var countryList:ArrayList<WorldCupDataModel>) :
    BaseAdapter(){
    override fun getCount(): Int {
        return countryList.size
    }

    override fun getItem(position: Int): Any {
        return countryList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: MyViewHolder
        if(convertView == null){
            var inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.cuplayout, null)
            viewHolder = MyViewHolder(view)
            view?.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as MyViewHolder
        }

        var country = countryList[position]
        viewHolder.countryName?.text = country.countryName
        viewHolder.cupWins?.text = country.cupWins
        viewHolder.flagImage?.setImageResource(country.flagImage)

        view?.setOnClickListener(){
            Toast.makeText(activity, country.countryName, Toast.LENGTH_LONG).show()
        }
        return view as View
    }

    private class MyViewHolder(view: View?){
        var countryName: TextView ? = null
        var cupWins: TextView ? = null
        var flagImage: ImageView? = null

        init {
            countryName = view?.findViewById(R.id.countryNameText)
            cupWins = view?.findViewById(R.id.cupWinText)
            flagImage = view?.findViewById(R.id.imageView)
        }

    }
}