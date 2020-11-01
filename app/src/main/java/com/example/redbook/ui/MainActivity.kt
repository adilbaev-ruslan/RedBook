package com.example.redbook.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.redbook.R
import com.example.redbook.data.model.Book
import com.example.redbook.ui.book.BookFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TYPE_ID = "typeId"
        const val INVERTABRATES = 1
        const val FISHES = 2
        const val REPTILES = 3
        const val BIRDS = 4
        const val MAMMALS = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val defaultFragment = BookFragment()
        val bundle = Bundle()
        bundle.putInt(TYPE_ID, INVERTABRATES)
        defaultFragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContext, defaultFragment).commit()

        navView.setNavigationItemSelectedListener {
            val selectedFragment = BookFragment()
            when(it.itemId) {
                R.id.nav_invertabrates -> {
                    bundle.putInt(TYPE_ID, INVERTABRATES)
                    selectedFragment.arguments = bundle
                }
                R.id.nav_fishes -> {
                    bundle.putInt(TYPE_ID, FISHES)
                    selectedFragment.arguments = bundle
                }
                R.id.nav_reptiles -> {
                    bundle.putInt(TYPE_ID, REPTILES)
                    selectedFragment.arguments = bundle
                }
                R.id.nav_birds -> {
                    bundle.putInt(TYPE_ID, BIRDS)
                    selectedFragment.arguments = bundle
                }
                R.id.nav_mammals -> {
                    bundle.putInt(TYPE_ID, MAMMALS)
                    selectedFragment.arguments = bundle
                }
                else -> return@setNavigationItemSelectedListener false
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContext, selectedFragment).commit()
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}