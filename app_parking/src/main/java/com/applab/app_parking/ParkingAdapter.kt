package com.applab.app_parking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ParkingAdapter (val list: List<Map<String, Object>>) : RecyclerView.Adapter<ParkingAdapter.ParkingHolder>() {

    private lateinit var context: Context
    class ParkingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parkName: TextView = itemView.text_parkName
        val surplusSpace: TextView = itemView.text_surplusSpace
        val totalSpace: TextView = itemView.text_totalSpace
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingHolder {
        context = parent.context
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.item, parent, false
        )
        return ParkingHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ParkingHolder, position: Int) {
        val currentItem = list[position]
        holder.parkName.text = position.toString() + ":" + currentItem["parkName"].toString()
        holder.surplusSpace.text = currentItem["surplusSpace"].toString()
        holder.totalSpace.text = currentItem["totalSpace"].toString().toDouble().toInt().toString()
        holder.parkName.setOnClickListener {
            Toast.makeText(context, list[position].toString(), Toast.LENGTH_SHORT).show()
        }
    }


}