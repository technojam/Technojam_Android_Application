package com.teamtechnojam.technojam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView
import com.teamtechnojam.technojam.R
import com.teamtechnojam.technojam.model.MembersModel

class MembersAdapter(
    private val context: Context,
    private val membersList: ArrayList<MembersModel>
) : RecyclerView.Adapter<MembersAdapter.ViewHolder>() {

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val ivProfilePic = item.findViewById<ShapeableImageView>(R.id.iv_memberImage)
        val tvMemberName = item.findViewById<TextView>(R.id.tv_itemMemberName)
        val tvPosition = item.findViewById<TextView>(R.id.tv_memberPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.team_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MembersAdapter.ViewHolder, position: Int) {
        val current = membersList[position]

        holder.tvMemberName.text = current.memberName
        holder.tvPosition.text = current.position
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide.with(context)
            .load(current.imageUrl)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.tj_logo)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.ivProfilePic)

    }

    override fun getItemCount(): Int {
        return membersList.size
    }


}