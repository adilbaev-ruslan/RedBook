package com.example.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.redbook.data.model.RedBook as RedBook1
//dao
@Dao
interface RedBookDao {
    @Query("SELECT * FROM book")
    fun getAll() : List<RedBook1>
}