package com.onlylivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLiveData(val startingNum: Int): ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalSum: LiveData<Int>
        get() = total

    init {
        total.value = startingNum
    }

    fun AddTen(){
        total.value = (total.value)?.plus(10)
    }

    fun AddInput(input: Int){
        total.value = (total.value)?.plus(input)
    }



}