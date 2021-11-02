package com.example.sharepreferences

import android.app.Application

class SharePreferencesApplication:Application() {

    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}