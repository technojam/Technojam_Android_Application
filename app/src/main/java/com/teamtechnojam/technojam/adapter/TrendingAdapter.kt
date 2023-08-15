package com.teamtechnojam.technojam.adapter

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView
import com.teamtechnojam.technojam.R
import com.teamtechnojam.technojam.model.TrendingModel

class TrendingAdapter(
    private val context: Context,
    private var itemList: ArrayList<TrendingModel>
) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    private val filteredItemList = ArrayList(itemList)

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val ivTopic = item.findViewById<ShapeableImageView>(R.id.iv_topicPoster)
        val tvtopicTitle = item.findViewById<TextView>(R.id.tv_topicTitle)
        val tvshortDescription = item.findViewById<TextView>(R.id.tv_shortDescription)
        val btnLearnMore = item.findViewById<AppCompatButton>(R.id.btn_learnMore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.trending_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TrendingAdapter.ViewHolder, position: Int) {
        val current = itemList[position]
        holder.tvtopicTitle.text = current.topicTitle
        holder.tvshortDescription.text = current.description

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide.with(context)
            .load(current.imageUrl)
            .placeholder(circularProgressDrawable)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.ivTopic)

        holder.btnLearnMore.setOnClickListener {
            openUrlInBrowser(current.webSiteUrl)
        }

    }

    private fun openUrlInBrowser(websiteUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
        browserIntent.setPackage("com.android.chrome")

        val packageManager = context.packageManager

        val chromeInfo =
            packageManager.resolveActivity(browserIntent, PackageManager.MATCH_DEFAULT_ONLY)
        val isChromeInstalled = chromeInfo != null

        if (isChromeInstalled) {
            context.startActivity(browserIntent)
        } else {

            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    fun filter(filterList: ArrayList<TrendingModel>) {
        itemList = filterList
        notifyDataSetChanged()
    }
}