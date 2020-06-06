package com.example.assignment.ui.login

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.adapter.MyFeedAdapter
import com.example.assignment.listener.RecyclerItemClickListenr
import com.example.assignment.model.FeedModel
import com.example.assignment.view_model.FeedViewModel

class DashboardActivity : AppCompatActivity() {

private var progressDialog:ProgressDialog?=null
    var  feedViewModel: FeedViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
     val top_feed_list=findViewById(R.id.top_feed_list) as RecyclerView

        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        showProgressDialog()
        feedViewModel!!.feed_list.observe(this,object:Observer<ArrayList<FeedModel>>{
            @SuppressLint("WrongConstant")
            override fun onChanged(t: ArrayList<FeedModel>?) {
               val myadapter= MyFeedAdapter(t)
              top_feed_list.layoutManager=LinearLayoutManager(this@DashboardActivity, LinearLayout.VERTICAL,false)
               top_feed_list.adapter=myadapter
               hideProgressDialog()
                top_feed_list.addOnItemTouchListener(RecyclerItemClickListenr(this@DashboardActivity,top_feed_list,object:RecyclerItemClickListenr.OnItemClickListener{
                    override fun onItemClick(view: View, position: Int) {
                        if (t != null) {
                            redirectToNewsDetails(t.get(position).title)

                        }
                    }

                    override fun onItemLongClick(view: View?, position: Int) {

                    }

                }))

            }
        })
    }
    public fun hideProgressDialog(){
        progressDialog?.hide()
        }

    public fun showProgressDialog(){
        progressDialog = ProgressDialog(this@DashboardActivity)
        progressDialog!!.setTitle("News")
        progressDialog!!.setMessage("Loading News ...")
        progressDialog!!.show()
    }




public fun redirectToNewsDetails(news_id:String){

    var intent=Intent(this,NewsDetailsActivity::class.java)
    intent.putExtra("news_id",news_id)
    startActivity(intent)
}



}
