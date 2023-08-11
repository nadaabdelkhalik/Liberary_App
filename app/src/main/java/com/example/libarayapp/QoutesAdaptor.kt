package com.example.libarayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class QoutesAdaptor(): RecyclerView.Adapter<QoutesAdaptor.qoutesHolder>() {
    var qoutesList:ArrayList<String> =arrayListOf<String>()
    inner class qoutesHolder(view:View):ViewHolder(view)
    {

        val qoute:TextView=view.findViewById(R.id.qoute)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): qoutesHolder{
        val view= LayoutInflater.from(parent.context).inflate(R.layout.qoutes_list_item,parent,false)
        return qoutesHolder(view)

    }

    override fun getItemCount(): Int {
        return qoutesList.size
    }

    override fun onBindViewHolder(holder: qoutesHolder, position: Int) {
        holder.qoute.text=qoutesList[position]






    }

    fun setData(list: List<String>) {
        qoutesList.clear()
        qoutesList.addAll(list)
        notifyDataSetChanged()
    }


}