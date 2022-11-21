package com.example.contactapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert
   suspend fun insertContact(contact: Contacts)

    @Update
    suspend fun updateContact(contact: Contacts)

    @Delete
    suspend fun deleteContact(contact: Contacts)

    @Query("select * from contact")
    fun getContacts(): LiveData<List<Contacts>>
}