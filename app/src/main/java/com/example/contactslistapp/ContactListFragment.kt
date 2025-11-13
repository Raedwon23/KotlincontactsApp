//Raghav Dhawan
//1191209
// INFO-3136 Project 1
// This is the contact list fragment
package com.example.contactslistapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Class
class ContactListFragment : Fragment(R.layout.fragment_contact_list) {

    // Declaring two vars one for recycler view and another for contact adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var contactAdapter: ContactAdapter


    companion object {
        val contactList = mutableListOf<Contact>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewContacts)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Load saved contacts when fragment opens
        if (contactList.isEmpty()) {
            contactList.addAll(ContactStorageHelper.loadContacts(requireContext()))
        }

        contactAdapter = ContactAdapter(contactList)
        recyclerView.adapter = contactAdapter
    }

    fun refreshList() {
        contactAdapter.notifyDataSetChanged()
    }
}
