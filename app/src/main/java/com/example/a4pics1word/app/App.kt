package com.example.a4pics1word.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.a4pics1word.repository.SharedPref

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        SharedPref.init(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: Context
            private set
    }
}