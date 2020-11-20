package com.example.redbook.ui.fovarites

import com.example.redbook.data.dao.BookDao

class FovaritesPresenter(private val dao: BookDao, private val view: FovaritesView) {
    fun getByFovarites() {
        view.setData(dao.getByFovarites())
    }
}