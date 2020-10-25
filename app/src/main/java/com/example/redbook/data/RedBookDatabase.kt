package com.example.redbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.redbook.data.dao.BookDao
import com.example.redbook.data.model.Book

@Database(entities = [Book::class], version = 1)
abstract class RedBookDatabase: RoomDatabase() {

    private lateinit var INSTANCE: RedBookDatabase

    companion object{
        fun getInstance(context: Context) : RedBookDatabase =
            Room.databaseBuilder(context, RedBookDatabase::class.java, "book-database.db")
                .createFromAsset("book-database.db")
                .allowMainThreadQueries()
                .build()
    }

    abstract fun dao(): BookDao
}