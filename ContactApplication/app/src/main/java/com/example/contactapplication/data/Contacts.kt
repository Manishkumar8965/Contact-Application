package com.example.contactapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val number: String?,
    val address: String?
)
