package com.example.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.redbook.data.model.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAll() : List<Book>
}