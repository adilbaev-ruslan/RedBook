package com.example.redbook.ui.book

import com.example.redbook.data.dao.BookDao
import com.example.redbook.data.model.Book

class BookPresenter(private val dao: BookDao) {

    private var setData: (models: List<Book>) -> Unit = {
       // setData ele realizatsiay qilinbadi
    }

    fun setDataBody(setData: (models: List<Book>) -> Unit) {
        this.setData = setData
    }

    fun getAll(type: Int) {
        setData.invoke(dao.getAll(type))
    }
    fun getSearchByName(type: Int, word: String){
        setData.invoke(dao.getSearchByName(type, word))
    }
}