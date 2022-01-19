package com.musnadil.suitmediaapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.musnadil.suitmediaapp.Models.Data
import com.musnadil.suitmediaapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemlist.view.*

class DataAdapter (
    val dataList:MutableList<Data>
    ):RecyclerView.Adapter<DataAdapter.ViewHolder>(){
    private lateinit var context : Context
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val nama = view.tvUsername
        val email = view.tvEmail
        val imgAvatar = view.imgAva

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlist,parent,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = dataList[position]
        val fullname = "${person.firstName} ${person.lastName}"

        holder.nama.text = fullname
        holder.email.text = person.email
        Picasso.get()
            .load(person.avatar)
            .into(holder.imgAvatar)
    }

    override fun getItemCount()=dataList.size
}