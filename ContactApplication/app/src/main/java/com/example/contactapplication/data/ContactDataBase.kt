package com.example.contactapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Contacts::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO

    companion object {
        @Volatile
        private var INSTACE: ContactDataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): ContactDataBase {
            if (INSTACE == null) {
                synchronized(this) {
                    INSTACE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            ContactDataBase::class.java,
                            "contactDB"
                        ).build()
                }
            }
            return INSTACE!!
        }
    }

}