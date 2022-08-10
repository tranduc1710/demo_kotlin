package com.tranduc.demokotlin.model

import java.time.LocalDate

data class Gallery(
    val date: LocalDate,
    val lImage: MutableList<ImageGallery>
)
