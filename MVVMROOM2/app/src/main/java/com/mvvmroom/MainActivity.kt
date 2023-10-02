package com.mvvmroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvmroom.databinding.ActivityMainBinding
import com.mvvmroom.myviewmodel.UserViewModel
import com.mvvmroom.myviewmodel.ViewModelFactory
import com.mvvmroom.room.User
import com.mvvmroom.room.UserDatabase
import com.mvvmroom.room.UserRepository
import com.mvvmroom.viewUI.MyRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Room Database
        val dao = UserDatabase.getInstence(application).userDAO
        val repository = UserRepository(dao)
        val factory = ViewModelFactory(repository)

        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        binding.userViewModel = userViewModel

        binding.lifecycleOwner = this

        initRecycleView()
    }
    private fun initRecycleView(){
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        DisplayUserList()
    }

    fun DisplayUserList(){
        userViewModel.users.observe(this,
            Observer {
                binding.recycleView.adapter = MyRecyclerViewAdapter(
                    it
                ) { selectedItem: User ->
                    listItemClicked(selectedItem)
                }
            })
    }

    private fun listItemClicked(selectedItem: User) {
        Toast.makeText(this, "Selected name is ${selectedItem.name}", Toast.LENGTH_LONG).show()

        userViewModel.initUpdataAndDelete(selectedItem)
    }


}