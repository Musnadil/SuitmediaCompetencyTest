package com.musnadil.suitmediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.musnadil.suitmediaapp.Adapters.DataAdapter
import com.musnadil.suitmediaapp.Models.ApiReqres
import com.musnadil.suitmediaapp.Models.Data
import kotlinx.android.synthetic.main.activity_third_screen.*

class ThirdScreen : AppCompatActivity() {
    private val dataList:MutableList<Data> = mutableListOf()
    private lateinit var dataAdapter : DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)
        var actionBar = getSupportActionBar()
        // set nama activity pada actionbar
        actionBar!!.title = "Third Screen"
        // menampilkan back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        // setup adapter
        dataAdapter = DataAdapter(dataList)

        // setup recycler view
        rvListData.layoutManager = LinearLayoutManager(this)
        rvListData.addItemDecoration(DividerItemDecoration(this,OrientationHelper.VERTICAL))
        rvListData.adapter = dataAdapter

        // setup android networking
        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://reqres.in/api/users?page=1&per_page=10")
            .build()
            .getAsObject(ApiReqres::class.java,object :ParsedRequestListener<ApiReqres>{
                override fun onResponse(response: ApiReqres) {
                    if (response.data.isEmpty()){
                        dataEmpty.visibility = View.VISIBLE
                    }else{
                    dataList.addAll(response.data)
                    dataAdapter.notifyDataSetChanged()
                    }
                }
                override fun onError(anError: ANError?) {
                }

            })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}