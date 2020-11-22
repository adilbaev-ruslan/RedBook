package com.example.redbook.ui.fovarites

import com.example.redbook.data.dao.BookDao
import com.example.redbook.data.model.Book

class FovaritesPresenter(private val dao: BookDao) {

    private var setDataFovarit: (models: List<Book>) -> Unit = {
        // setDataFovarit ele realizatsiay qilinbadi
    }

    fun setDataFovaritBody(setDataFovarit: (models: List<Book>) -> Unit) {
        this.setDataFovarit = setDataFovarit
    }

    fun getByFovarites() {
        setDataFovarit.invoke(dao.getByFovarites())
    }
}