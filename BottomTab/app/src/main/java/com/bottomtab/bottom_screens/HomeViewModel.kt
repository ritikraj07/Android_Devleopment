package com.bottomtab.bottom_screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var total = MutableLiveData<Int>(0)
    fun add(){
        total.value = total.value?.plus(1)
    }
}