package com.tranduc.demokotlin.screen.gallerygrid

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tranduc.demokotlin.R
import com.tranduc.demokotlin.model.Gallery


class GalleryGridAdapter(private val lGallery: MutableList<Gallery>) : RecyclerView.Adapter<GalleryGridAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDateTime: TextView = itemView.findViewById(R.id.tvDateTime)
        val rvItemTop: RecyclerView = itemView.findViewById(R.id.rvItemTop)
        val rvItemBottom: RecyclerView = itemView.findViewById(R.id.rvItemBottom)
    }

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryGridAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_gallery_grid, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: GalleryGridAdapter.ViewHolder, position: Int) {
        val item = lGallery[position]

        holder.tvDateTime.text = item.date.toString()

        val manager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        holder.rvItemTop.layoutManager = manager

        val countItemRedundant = item.lImage.size % 2

        val lItemFirst = item.lImage.subList(0, item.lImage.size - countItemRedundant)
        val adapter = ItemGalleryGridAdapter(lItemFirst)
        holder.rvItemTop.adapter = adapter

        holder.rvItemBottom.layoutManager = LinearLayoutManager(context)
        if (countItemRedundant > 0) {
            val lItemLast = item.lImage.subList(item.lImage.size - countItemRedundant, item.lImage.size)
            holder.rvItemBottom.adapter = ItemGalleryGridAdapter(lItemLast)
        }
    }

    override fun getItemCount(): Int {
        return lGallery.size
    }
}
