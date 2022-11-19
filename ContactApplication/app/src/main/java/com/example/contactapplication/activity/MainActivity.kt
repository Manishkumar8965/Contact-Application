package com.example.contactapplication.activity

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactapplication.R
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapplication.RecyclerAdapter
import com.example.contactapplication.data.Contacts
import com.example.contactapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    var adapter1: RecyclerAdapter? = null
    var animals: ArrayList<Contacts> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        animals = getLandmarks()
        binding.rvContactList.layoutManager = LinearLayoutManager(this)
        adapter1 = RecyclerAdapter(animals, this)
        binding.rvContactList.adapter = adapter1
        binding.rvContactList.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddContact::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

    fun getLandmarks(): ArrayList<Contacts> = arrayListOf(
        Contacts("Mt. Kenya", "1234567890"),
        Contacts("Naveen", "1234567890"),
        Contacts("Mittal", "1234567890"),
        Contacts("Kanu sharma", "1234567890"),
        Contacts("New India", "1234567890"),
        Contacts("My Contact", "1234567890"),
        Contacts("High Valyu", "1234567890"),
        Contacts("Non Number", "1234567890"),
        Contacts("My Contact", "1234567890"),
        Contacts("High Valyu", "1234567890"),
        Contacts("Non Number", "1234567890")
    )
}