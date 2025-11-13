//Raghav Dhawan
//1191209
// INFO-3136 Project 1
// Fragment to add a new phone contact to the contact list and save it.

package com.example.contactslistapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


// This fragment is required for adding Phone contact
class AddPhoneFragment : Fragment(R.layout.fragment_add_phone) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // FInd the edit text for the input fields
        val nameEditText = view.findViewById<EditText>(R.id.editTextNamePhone)
        val phoneEditText = view.findViewById<EditText>(R.id.editTextPhone)
        val submitButton = view.findViewById<Button>(R.id.buttonSubmitPhone)


        // This is an event listener for the submit button
        submitButton.setOnClickListener {
            // fetch the value
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()

            // Making sure it aint empty
            if (name.isNotEmpty() && phone.isNotEmpty()) {
                val contact = Contact(name, phone, ContactType.PHONE)
                ContactListFragment.contactList.add(contact)

                // Save the updated list
                ContactStorageHelper.saveContacts(requireContext(), ContactListFragment.contactList)

                // Refresh the Contact List
                requireActivity().supportFragmentManager.fragments.forEach {
                    if (it is ContactListFragment) {
                        it.refreshList()
                    }
                }

                // Showing a message of confirmation
                Toast.makeText(requireContext(), "Contact Added!", Toast.LENGTH_SHORT).show()

                // Clear the fields for the next input
                nameEditText.text.clear()
                phoneEditText.text.clear()
            }
        }

    }
}
