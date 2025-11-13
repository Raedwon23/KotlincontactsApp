//Raghav Dhawan
//1191209
// INFO-3136 Project 1
//This is an adapter class for displaying the contacts in recycler view

package com.example.contactslistapp
// imports
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

        // This is a class that holds a reference to the views for each contact
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textDetail: TextView = itemView.findViewById(R.id.textDetail)
        val buttonAction: ImageButton = itemView.findViewById(R.id.buttonAction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.textName.text = contact.name
        holder.textDetail.text = contact.detail

        // Setting different icons based on contact type
        if (contact.type == ContactType.PHONE) {
            holder.buttonAction.setImageResource(android.R.drawable.ic_menu_call)
        } else {
            holder.buttonAction.setImageResource(android.R.drawable.ic_dialog_email)
        }

        // Handle button click
        holder.buttonAction.setOnClickListener {
            val context = holder.itemView.context
            // Create dial intent for phone contact
            val intent = if (contact.type == ContactType.PHONE) {
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:${contact.detail}"))
            }

            // Create email intent for email contact
            else {
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${contact.detail}"))
            }
            // Launch the intent
            context.startActivity(intent)
        }
    }

    // This returns the total number of contacts
    override fun getItemCount(): Int = contactList.size
}
