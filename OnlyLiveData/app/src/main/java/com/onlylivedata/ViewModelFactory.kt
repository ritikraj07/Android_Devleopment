package com.onlylivedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val startingNum: Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewModelLiveData::class.java)){
            return ViewModelLiveData(startingNum) as T
        }
        throw IllegalArgumentException("Never mess with me")
    }

}