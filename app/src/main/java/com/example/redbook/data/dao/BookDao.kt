package com.example.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.redbook.data.model.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM book WHERE type = :type")
    fun getAll(type: Int) : List<Book>

    @Query("SELECT * FROM book WHERE id = :id")
    fun getById(id: Int) : Book

    @Query("SELECT * FROM book WHERE type= :type and nameEng LIKE :word")
    fun getSearchByName(type: Int, word: String): List<Book>
}