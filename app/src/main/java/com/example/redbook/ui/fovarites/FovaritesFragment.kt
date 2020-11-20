package com.example.redbook.ui.fovarites

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbook.R
import com.example.redbook.data.RedBookDatabase
import com.example.redbook.data.dao.BookDao
import com.example.redbook.data.model.Book
import com.example.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_fovarites.*

class FovaritesFragment: Fragment(R.layout.fragment_fovarites), FovaritesClickLissiner, FovaritesView {
    val fovaritesAdapter = FovaritesListAdapter(this)
    private lateinit var dao: BookDao
    private lateinit var presenter: FovaritesPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFovarites.adapter = fovaritesAdapter
        recyclerViewFovarites.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        presenter = FovaritesPresenter(dao, this)
        presenter.getByFovarites()
    }

    override fun onCickFovarite(id: Int) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.BOOK_ID, id)
        startActivity(intent)
    }

    override fun setData(models: List<Book>) {
        fovaritesAdapter.models = models
    }

    override fun onStart() {
        super.onStart()
        presenter.getByFovarites()
    }
}