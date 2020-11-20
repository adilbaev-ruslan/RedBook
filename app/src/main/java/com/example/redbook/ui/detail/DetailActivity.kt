package com.example.redbook.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.redbook.R
import com.example.redbook.data.RedBookDatabase
import com.example.redbook.data.dao.BookDao
import com.example.redbook.data.model.Book
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val BOOK_ID = "bookId"
    }

    private var bookId = 0
    private lateinit var currentBook: Book
    private lateinit var dao: BookDao
    private var menuItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Details")

        dao = RedBookDatabase.getInstance(this).dao()

        bookId = intent.getIntExtra(BOOK_ID, 0)
        currentBook = dao.getById(bookId)

        tvStatusContext.text = currentBook.status
        tvPropagationContext.text = currentBook.propagation
        tvHabitatContext.text = currentBook.habitat
        tvQuantityContext.text = currentBook.quantity
        tvLifestyleContext.text = currentBook.lifestyle
        tvLimitingFactorsContext.text = currentBook.limitingFactors
        tvBreedingContext.text = currentBook.breeding
        tvSecurityContext.text = currentBook.security
        Glide
            .with(this)
            .load(resources.getIdentifier("picture${bookId}", "drawable", packageName))
            .into(ivDetailImage)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
            R.id.isFovarite -> setFovarite()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        menuItem = menu?.findItem(R.id.isFovarite)
        setFovariteIcon()
        return true
    }

    private fun setFovarite() {
        if (currentBook.isFovarite == null)
            currentBook.isFovarite = 1
        else currentBook.isFovarite = 1 - currentBook.isFovarite!!
        setFovariteIcon()
        dao.updateBook(currentBook)
    }

    private fun setFovariteIcon(){
        if (currentBook.isFovarite == 1) {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_24)
        } else {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_border_24)
        }
    }

}

