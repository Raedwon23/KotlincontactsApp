//Raghav Dhawan
//1191209
// INFO-3136 Project 1
// Main class

package com.example.contactslistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize bottom navigation view
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Load default fragment (Contact List)
        loadFragment(ContactListFragment())

        // Highlight Contact List manually
        bottomNavigationView.selectedItemId = R.id.nav_contacts

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_contacts -> {
                    loadFragment(ContactListFragment())
                    true
                }
                R.id.nav_add_email -> {
                    loadFragment(AddEmailFragment())
                    true
                }
                R.id.nav_add_phone -> {
                    loadFragment(AddPhoneFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
