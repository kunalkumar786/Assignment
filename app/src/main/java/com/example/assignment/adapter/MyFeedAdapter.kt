package com.example.assignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.model.FeedModel
import com.example.assignment.ui.login.DashboardActivity
import com.example.assignment.ui.login.NewsDetailsActivity
import kotlin.collections.ArrayList
//private var t: ArrayList<FeedModel>?=null
class MyFeedAdapter(
 val  t: ArrayList<FeedModel>?
) : RecyclerView.Adapter<MyFeedAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFeedAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: MyFeedAdapter.ViewHolder, position: Int) {
        t?.get(position)?.let { holder.bindItems(it) }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return t!!.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: FeedModel) {
            val tv_title = itemView.findViewById(R.id.tv_title) as TextView
            val tv_description = itemView.findViewById(R.id.tv_description) as TextView
            val iv_feed=itemView.findViewById(R.id.iv_feed) as ImageView
            val rl_main=itemView.findViewById(R.id.rl_main) as RelativeLayout
            tv_title.text = user.title
            tv_description.text = user.description?:"Description"

        }
    }
}


