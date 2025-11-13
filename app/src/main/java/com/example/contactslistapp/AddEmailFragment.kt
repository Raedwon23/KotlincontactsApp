//Raghav Dhawan
//1191209
// INFO-3136 Project 1
// Fragment to add a new email contact to the contact list and save it.

package com.example.contactslistapp
// imports
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

// This fragment is required for adding Emails
class AddEmailFragment : Fragment(R.layout.fragment_add_email) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // FInd the edit text for the input fields
        val nameEditText = view.findViewById<EditText>(R.id.editTextNameEmail)
        val emailEditText = view.findViewById<EditText>(R.id.editTextEmail)
        val submitButton = view.findViewById<Button>(R.id.buttonSubmitEmail)

        // This is an event listener for the submit button
        submitButton.setOnClickListener {
            // Fetch the actual values
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            // Making sure that the fields arent empty
            if (name.isNotEmpty() && email.isNotEmpty()) {
                // Make a new contact object which is in the contact.kt
                val contact = Contact(name, email, ContactType.EMAIL)
                // This adds the conatct to the list
                ContactListFragment.contactList.add(contact)

                // Save the updated list
                ContactStorageHelper.saveContacts(requireContext(), ContactListFragment.contactList)

                // Refresh the Contact List
                requireActivity().supportFragmentManager.fragments.forEach {
                    if (it is ContactListFragment) {
                        it.refreshList()
                    }
                }

                // Show a Toast of confirmation
                Toast.makeText(requireContext(), "Contact Added!", Toast.LENGTH_SHORT).show()

                // Clear the fields for the nect input
                nameEditText.text.clear()
                emailEditText.text.clear()
            }
        }

    }
}// end class
