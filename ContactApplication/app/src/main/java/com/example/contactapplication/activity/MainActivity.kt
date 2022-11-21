package com.example.contactapplication.activity

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactapplication.R
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.contactapplication.RecyclerAdapter
import com.example.contactapplication.data.ContactDataBase
import com.example.contactapplication.data.Contacts
import com.example.contactapplication.data.DBHelper
import com.example.contactapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var database: ContactDataBase

    var adapter1: RecyclerAdapter? = null
    var contactListToDisplay: ArrayList<Contacts> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvContactList.layoutManager = LinearLayoutManager(this)
        adapter1 = RecyclerAdapter(contactListToDisplay, this)
        binding.rvContactList.adapter = adapter1

        binding.rvContactList.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        database = ContactDataBase.getDatabase(this)

        database.contactDao().getContacts().observe(this, Observer {
            contactListToDisplay.clear()
            for (cont in it)
                contactListToDisplay.add(cont)
            adapter1?.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddContact::class.java)

            startActivity(intent)
        }

    }
}