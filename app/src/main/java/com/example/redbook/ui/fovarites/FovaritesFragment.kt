package com.example.redbook.ui.fovarites

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbook.R
import com.example.redbook.data.RedBookDatabase
import com.example.redbook.data.dao.BookDao
import com.example.redbook.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_fovarites.*

class FovaritesFragment: Fragment(R.layout.fragment_fovarites), FovaritesClickLissiner {
    val fovaritesAdapter = FovaritesListAdapter(this)
    private lateinit var dao: BookDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFovarites.adapter = fovaritesAdapter
        recyclerViewFovarites.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        setData(1)
    }

    private fun setData(isFovarites: Int) {
        fovaritesAdapter.models = dao.getByFovarites(isFovarites)
    }

    override fun onCickFovarite(id: Int) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.BOOK_ID, id)
        startActivity(intent)
    }
}