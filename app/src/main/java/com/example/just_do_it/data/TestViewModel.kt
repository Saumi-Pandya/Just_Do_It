package com.example.just_do_it.data

import androidx.lifecycle.ViewModel
import timber.log.Timber

class TestViewModel : ViewModel(){

    private var count: Int = 0

    fun getCount():Int{
        return count
    }

    init{
        Timber.e("ViewModel initialized")
    }

    fun incrementCounter(){
        count++
    }

    override fun onCleared() {
        super.onCleared()
        Timber.e("On cleared called")
    }
}