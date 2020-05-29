package com.example.assignment.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.assignment.R
import com.example.assignment.view_model.FeedViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
var   feedViewModel: FeedViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        feedViewModel!!.feedData.observe(this,object:Observer<String>{
            override fun onChanged(t: String?) {
                tv_detail.setText(t)
                
            }
        })
    }
}
