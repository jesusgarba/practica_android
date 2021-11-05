package com.example.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int,
    val address: String,
    val isDone: Boolean = false
)