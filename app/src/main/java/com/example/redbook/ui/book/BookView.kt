package com.example.redbook.ui.book

import com.example.redbook.data.model.Book

interface BookView {
    fun setData(models: List<Book>)
}