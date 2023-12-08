package com.example.viewmodel

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private var counter = 0

    fun getIntialCounter(): Int {
        return counter
    }

    fun getUpdatedCounter(): Int {
        return ++counter
    }
}