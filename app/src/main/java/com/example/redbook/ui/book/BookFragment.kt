package com.example.redbook.ui.book

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbook.R
import com.example.redbook.data.RedBookDatabase
import com.example.redbook.data.dao.BookDao
import com.example.redbook.data.model.Book
import com.example.redbook.ui.MainActivity
import com.example.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment: Fragment(R.layout.fragment_book) {

    private val bookAdapter = BookListAdapter()
    private lateinit var dao: BookDao
    private lateinit var presenter: BookPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type = arguments?.getInt(MainActivity.TYPE_ID) ?: 1

        recyclerView.adapter = bookAdapter
        bookAdapter.setOnClickedListiner {id->
            val intent = Intent(requireActivity(), DetailActivity::class.java)
            intent.putExtra(DetailActivity.BOOK_ID, id)
            startActivity(intent)
        }
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        presenter = BookPresenter(dao)
        presenter.setDataBody {
            bookAdapter.models = it
        }
        presenter.getAll(type)

        etSearch.addTextChangedListener {
            presenter.getSearchByName(type, "%${it.toString()}%")
        }
    }
}