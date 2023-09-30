package com.viewmodel

import androidx.lifecycle.ViewModel

open class MainActivityViewModel(startingNum: Int) : ViewModel() {

    var count = startingNum
    fun GetCount():Int{
        return count
    }
    fun IncreaseCount():Int{
        return ++count
    }
}