package com.example.room

import android.app.Application
import androidx.room.Room

class PersonApp: Application() {

    companion object {
        lateinit var app: PeopleDb
    }

    override fun onCreate() {
        super.onCreate()
        PersonApp.app = Room
            .databaseBuilder(this, PeopleDb::class.java, "people")
            .build()
    }
}