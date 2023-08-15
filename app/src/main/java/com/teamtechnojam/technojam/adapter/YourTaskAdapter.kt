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
import com.teamtechnojam.technojam.model.YourTaskModel

class YourTaskAdapter(
    private val context: Context,
    private val taskList: ArrayList<YourTaskModel>
) : RecyclerView.Adapter<YourTaskAdapter.ViewHolder>() {

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val taskTitle = item.findViewById<TextView>(R.id.tv_taskTitle)
        val assigndBy = item.findViewById<TextView>(R.id.tv_assignBy)
        val buttonAccept = item.findViewById<AppCompatButton>(R.id.btn_accept)
        val buttonDecline = item.findViewById<AppCompatButton>(R.id.btn_decline)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.task_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = taskList[position]
        holder.taskTitle.text = current.title
        holder.assigndBy.text = current.assignBy

        holder.buttonAccept.setOnClickListener {
            Toast.makeText(context, "${current.title} Task Accepted", Toast.LENGTH_SHORT).show()
        }

        holder.buttonDecline.setOnClickListener {
            Toast.makeText(context, "${current.title} Task Declined", Toast.LENGTH_SHORT).show()
        }
    }
}