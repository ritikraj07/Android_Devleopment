package com.bottomtab.bottom_screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bottomtab.R
import com.bottomtab.databinding.FragmentHomeBinding

class Home : Fragment() {

    companion object {
        fun newInstance() = Home()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.count.text = viewModel.total.toString()

        binding.btm.setOnClickListener(){
            viewModel.add()
        }

        viewModel.total.observe(viewLifecycleOwner, Observer {
            binding.count.text = it.toString()
        })




    }

}