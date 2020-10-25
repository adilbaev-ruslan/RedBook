package com.example.redbook.ui.book

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redbook.R
import com.example.redbook.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookListAdapter(): RecyclerView.Adapter<BookListAdapter.BookViewHolder>(){

    var models: List<Book> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.pupulateModel(models[position])
    }

    override fun getItemCount(): Int =models.size

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun pupulateModel(book: Book){
            itemView.tvNameUzb.text = book.nameUzb
            itemView.tvNameRus.text = book.nameRus
            itemView.tvNameEng.text = book.nameEng
        }
    }

}