package com.example.a4pics1word.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a4pics1word.repository.SharedPref

class HomeViewModel : ViewModel() {

    val stateLiveData = MutableLiveData<List<Boolean>>()

    private val pref = SharedPref.getInstance()


    fun getState() {
        val list = ArrayList<Boolean>()
        list.add(pref.level2)
        list.add(pref.level3)

        stateLiveData.value = list
    }
}