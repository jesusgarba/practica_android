package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Person::class],
    version = 1
)

abstract class PeopleDb: RoomDatabase() {

    abstract fun personDao(): PersonDao

}