package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.room.PersonApp.Companion.app
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val peopleInsert = app.personDao().insert(mutableListOf(
                Person(0,"Jesus",23, "c/ moli", false),
                Person(0,"Jesus",23, "c/ moli", false),
                Person(0,"Jesus",23, "c/ moli", false)))
            val people = app.personDao().getAll()
            Log.d("ROOM_debug", "onCreate: ${people.size} people")
        }


    }
}