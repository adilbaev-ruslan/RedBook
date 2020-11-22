package com.example.redbook.ui.fovarites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.redbook.R
import com.example.redbook.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class FovaritesListAdapter: RecyclerView.Adapter<FovaritesListAdapter.FovaritesViewHolder>() {
    inner class FovaritesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun populateModel(book: Book) {
            itemView.tvNameEng.text = book.nameEng
            itemView.tvNameRus.text = book.nameRus
            itemView.tvNameUzb.text = book.nameUzb

            val imageName: String = "picture${book.id}"
            Glide
                .with(itemView)
                .load(itemView.context.resources.getIdentifier(imageName, "drawable", itemView.context.packageName))
                .into(itemView.ivBookImage)

            itemView.setOnClickListener {
                setOnClickedFovarit.invoke(book.id)
            }
        }
    }

    var models: List<Book> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var setOnClickedFovarit: (bookId: Int) -> Unit = {
        // setOnClickedFovarit ele realizatsiay qilinbadi
    }

    fun setOnClickedFovaritListiner(setOnClickedFovarit: (bookId: Int) -> Unit) {
        this.setOnClickedFovarit = setOnClickedFovarit
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FovaritesViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_fovarites, parent,false)
        return FovaritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FovaritesViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int = models.size
}