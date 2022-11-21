package com.example.contactapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.contactapplication.R
import com.example.contactapplication.data.ContactDataBase
import com.example.contactapplication.data.Contacts
import com.example.contactapplication.data.DBHelper
import com.example.contactapplication.databinding.ActivityAddContactBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddContact : AppCompatActivity() {

    lateinit var binding: ActivityAddContactBinding
    lateinit var database: ContactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_contact)







        binding.btnSubmit.setOnClickListener {

            val name = binding.edName.text.toString()
            val mobile = binding.edMobile.text.toString()
            val address = binding.edAddress.text.toString()
            database = ContactDataBase.getDatabase(this)
            GlobalScope.launch {
                database.contactDao().insertContact(Contacts(0, name, mobile, address))
            }

            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
            binding.edName.text.clear()
            binding.edMobile.text.clear()
            binding.edAddress.text.clear()


            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

    }
}