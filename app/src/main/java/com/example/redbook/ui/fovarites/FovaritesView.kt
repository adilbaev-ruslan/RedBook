package com.example.redbook.ui.fovarites

import com.example.redbook.data.model.Book

interface FovaritesView {
    fun setData(models: List<Book>)
}