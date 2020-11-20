package com.example.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.redbook.data.model.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM book WHERE type = :type")
    fun getAll(type: Int) : List<Book>

    @Query("SELECT * FROM book WHERE id = :id")
    fun getById(id: Int) : Book

    @Query("SELECT * FROM book WHERE type= :type and nameEng LIKE :word")
    fun getSearchByName(type: Int, word: String): List<Book>

    @Update
    fun updateBook(book: Book)

    @Query("SELECT * FROM book WHERE isFovarite= 1")
    fun getByFovarites(): List<Book>
}