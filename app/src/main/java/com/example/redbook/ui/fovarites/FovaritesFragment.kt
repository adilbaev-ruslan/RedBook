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

class FovaritesFragment: Fragment(R.layout.fragment_fovarites) {
    private val fovaritesAdapter = FovaritesListAdapter()
    private lateinit var dao: BookDao
    private lateinit var presenter: FovaritesPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFovarites.adapter = fovaritesAdapter
        fovaritesAdapter.setOnClickedFovaritListiner {id ->
            val intent = Intent(requireActivity(), DetailActivity::class.java)
            intent.putExtra(DetailActivity.BOOK_ID, id)
            startActivity(intent)
        }
        recyclerViewFovarites.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        presenter = FovaritesPresenter(dao)
        presenter.setDataFovaritBody {
            fovaritesAdapter.models = it
        }
        presenter.getByFovarites()
    }
    override fun onStart() {
        super.onStart()
        presenter.getByFovarites()
    }
}