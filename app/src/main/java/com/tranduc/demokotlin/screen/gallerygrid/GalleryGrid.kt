package com.tranduc.demokotlin.screen.gallerygrid

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tranduc.demokotlin.R

class GalleryGrid : AppCompatActivity() {
    private lateinit var presenter: GalleryGridPresenter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_grid)

        presenter = GalleryGridPresenter()

        presenter.getList()

        val rvParent = findViewById<RecyclerView>(R.id.rvParent)
        rvParent.layoutManager = LinearLayoutManager(this)

        val adapter = GalleryGridAdapter(presenter.lImageSort)
        rvParent.adapter = adapter
    }
}
