package com.example.contactapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapplication.data.Contacts
import com.example.contactapplication.databinding.RvContactListResourceBinding

class RecyclerAdapter(
    private val contact: List<Contacts>,
    private val context: Context,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val contList = ArrayList<Contacts>()

    class ViewHolder(private val contactBinding: RvContactListResourceBinding) :
        RecyclerView.ViewHolder(contactBinding.root) {

        fun bind(contact: Contacts) {
            contactBinding.tvName.text = contact.name
            contactBinding.tvMobileNumber.text = contact.number

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            RvContactListResourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contact.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(contact[position])
    }

    fun updateList(newList: List<Contacts>) {

    }
}