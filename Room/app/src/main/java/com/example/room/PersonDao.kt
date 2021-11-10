package com.example.room

import androidx.room.*

@Dao
interface PersonDao {

    @Query("SELECT * FROM Person")
     suspend fun getAll(): MutableList<Person>

    @Query("select * from person where id = :id")
     fun getById(id: Long): Person

    @Update
     fun update (person: Person): Int

    @Insert
     fun insert(people: List<Person>)

    @Insert fun insertPeople(person: Person): Long

    @Delete
     fun delete(person: Person): Int

}