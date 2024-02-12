package com.example.event

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var myString = MutableLiveData("")

    fun assignText() {
        myString.value = "value assigned"
    }
}