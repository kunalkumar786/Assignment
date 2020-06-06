package com.example.assignment.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.assignment.R
import com.example.assignment.view_model.FeedViewModel
import com.squareup.picasso.Picasso
import org.json.JSONObject
import java.lang.Exception
import java.lang.StringBuilder

class NewsDetailsActivity:AppCompatActivity(){
    var  feedViewModel: FeedViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_details_activity)
        val iv_user_icon=findViewById(R.id.iv_user_icon) as ImageView
         val tv_title=findViewById(R.id.tv_title) as TextView
        val tv_description=findViewById(R.id.tv_description) as TextView
        val iv_close=findViewById(R.id.iv_close) as ImageView
        val bundle :Bundle ?=intent.extras
    if(bundle!=null){
             val news_id: String? =bundle!!.getString("news_id")
        Log.d("NewsDetailsActivity==>",news_id)
        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        feedViewModel!!.getFeedData("/v0/item/"+news_id+".json").observe(this,object:Observer<String>{
            override fun onChanged(t: String?) {
            val jsonobj:JSONObject= JSONObject(t)

                tv_title.setText(jsonobj.getString("title"))
            try{
                Picasso
                    .with(this@NewsDetailsActivity) // give it the context
                    .load(jsonobj.getString("url")) // load the image
                    .placeholder(R.drawable.user_icon)
                    .into(iv_user_icon)

            }catch (e:Exception){
                e.printStackTrace()
            }
                val strinResult=StringBuilder()
                strinResult.append("id: ${jsonobj.getString("id")} \n")
                strinResult.append("score: ${jsonobj.getString("score")}\n")
                strinResult.append("time: ${jsonobj.getString("time")}\n")
                strinResult.append("type: ${jsonobj.getString("type")}\n")
                strinResult.append("kids: ${jsonobj.getJSONArray("kids")}")
                tv_description.setText(strinResult.toString())
            }

        })
        iv_close.setOnClickListener { finish() }

    }


    }

}