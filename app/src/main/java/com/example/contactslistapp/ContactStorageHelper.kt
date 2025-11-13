//Raghav Dhawan
//1191209
// INFO-3136 Project 1
// This Class is req. by

package com.example.contactslistapp

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ContactStorageHelper {
    private const val PREFS_NAME = "contacts_prefs"
    private const val CONTACTS_KEY = "contacts"

    private val gson = Gson()

    // This function is responsible for saving the contacts in JSON
    fun saveContacts(context: Context, contactList: List<Contact>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = gson.toJson(contactList)
        prefs.edit().putString(CONTACTS_KEY, json).apply()
    }

    // This extracts the info
    fun loadContacts(context: Context): MutableList<Contact> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(CONTACTS_KEY, null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<Contact>>() {}.type
            gson.fromJson(json, type)
        } else {


            mutableListOf()
        }
    }
}
