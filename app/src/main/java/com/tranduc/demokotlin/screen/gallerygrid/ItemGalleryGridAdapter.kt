package com.tranduc.demokotlin.screen.gallerygrid

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tranduc.demokotlin.R
import com.tranduc.demokotlin.model.ImageGallery

class ItemGalleryGridAdapter(private val lImage: List<ImageGallery>) : RecyclerView.Adapter<ItemGalleryGridAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivItemGallery: ImageView = itemView.findViewById(R.id.ivItemGallery)
    }

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image_gallery_grid, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lImage[position]

//        holder.ivItemGallery.setImageURI(Uri.parse(item.urlImage))
        Picasso.get()
            .load(Uri.parse(item.urlImage))
            .into(holder.ivItemGallery)
    }

    override fun getItemCount(): Int {
        return lImage.size
    }
}
