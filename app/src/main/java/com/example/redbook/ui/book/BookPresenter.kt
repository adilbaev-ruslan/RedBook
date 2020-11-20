package com.example.redbook.ui.book

import com.example.redbook.data.dao.BookDao

class BookPresenter(private val dao: BookDao, private val view: BookView) {
    fun getAll(type: Int) {
        view.setData(dao.getAll(type))
    }
    fun getSearchByName(type: Int, word: String){
        view.setData(dao.getSearchByName(type, word))
    }
}