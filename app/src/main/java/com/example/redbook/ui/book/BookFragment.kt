package com.example.redbook.ui.book

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbook.R
import com.example.redbook.data.RedBookDatabase
import com.example.redbook.data.dao.BookDao
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment: Fragment(R.layout.fragment_book) {

    private val bookAdapter = BookListAdapter()
    private lateinit var dao: BookDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = bookAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        setData()
    }
    private fun setData() {
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        bookAdapter.models = dao.getAll()
    }
}