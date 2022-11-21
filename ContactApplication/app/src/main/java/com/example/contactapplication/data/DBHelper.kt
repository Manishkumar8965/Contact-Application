package com.example.contactapplication.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "DB_CONTACTS"

        private val DATABASE_VERSION = 1

        val TABLE_NAME = "contacts_table"


        val ID_COL = "id"


        val NAME_COl = "name"


        val Mobile_Number_COL = "mobileNumber"

        val Address_COL = "address"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                Mobile_Number_COL + " TEXT" +
                Address_COL + " TEXT " + ")")
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addData(name: String, mobileNumber: String, address: String){

        val values = ContentValues()

        values.put(NAME_COl, name)
        values.put(Mobile_Number_COL, mobileNumber)
        values.put(Address_COL, address)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }
    fun getData():Cursor?{
        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }
}