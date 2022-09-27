package com.example.call_mapbox_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.model.EvPoints

class MainAdapter(private val openMapList: List<EvPoints?>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindData(evPoints: EvPoints?) {
            val id = itemView.findViewById<TextView>(R.id.id_name)
            id.text = evPoints?.ID.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_id, parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData((openMapList[position]))
    }

    override fun getItemCount(): Int {
        return openMapList.size
    }
}