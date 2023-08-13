package com.teamtechnojam.technojam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.teamtechnojam.technojam.R
import com.teamtechnojam.technojam.model.EventsModel

class EventsAdapter(
    private val context: Context,
    private val list: ArrayList<EventsModel>
) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val eventTitle: TextView = item.findViewById(R.id.tv_eventTitle)
        val eventDate: TextView = item.findViewById(R.id.tv_eventDate)
        val eventDescription: TextView = item.findViewById(R.id.tv_eventDescription)
        val feedbackButton: AppCompatButton = item.findViewById(R.id.btn_feedback)
        val resourceButton: AppCompatButton = item.findViewById(R.id.btn_resources)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.events_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EventsAdapter.ViewHolder, position: Int) {
        val current = list[position]
        holder.eventTitle.text = current.title
        holder.eventDate.text = current.date
        holder.eventDescription.text = current.description

        holder.feedbackButton.setOnClickListener {
            showFeedbackForm()
        }
        holder.resourceButton.setOnClickListener {
            getEventResources()
        }
    }

    private fun getEventResources() {
        Toast.makeText(context, "Resources Button is clicked", Toast.LENGTH_SHORT).show()
    }

    private fun showFeedbackForm() {
        Toast.makeText(context, "feedback button is clicked", Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}