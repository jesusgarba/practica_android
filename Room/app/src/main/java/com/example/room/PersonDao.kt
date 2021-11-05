package com.example.room

import androidx.room.*

@Dao
interface PersonDao {

    @Query("SELECT * FROM Person")
    suspend fun getAll(): List<Person>

    @Query("select * from person where id = :id")
    suspend fun getById(id: Int): Person

    @Update
    suspend fun update (person: Person)

    @Insert
    suspend fun insert(people: List<Person>)

    @Delete
    suspend fun delete(person: Person)

}