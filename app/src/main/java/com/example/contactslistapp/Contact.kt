//Raghav Dhawan
//1191209
// INFO-3136 Project 1
// This class is for Contact and ContactType definitions

package com.example.contactslistapp

// This defines the type of the contact
enum class ContactType {
    PHONE,
    EMAIL
}
// Data class for the information
data class Contact(
    val name: String,
    val detail: String,
    val type: ContactType
)
