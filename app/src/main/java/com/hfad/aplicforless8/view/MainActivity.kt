package com.hfad.aplicforless8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import com.hfad.aplicforless8.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMenuFragment()
        initMainFragment()
        initToolBar()
    }

    private fun initToolBar() {
     val toolbar: Toolbar = findViewById(R.id.toolBar_container)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)

        var search:MenuItem = menu!!.findItem(R.id.app_bar_search)
        val searchView : SearchView = search.actionView as SearchView
        searchView.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(name: String?): Boolean {
            //передаем текст от поиска
             getSearchFilm(name)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
               return true
            }

        })

        return true
    }

    private fun getSearchFilm(name: String?) {
//тут будет функция для поиска фильмов

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when (id){
            R.id.options -> openFragmentSettings()
        }

        return true
    }

    private fun openFragmentSettings() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container_fragment, SettingFragment.newInstance())
            .commit()
    }

    private fun initMenuFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.menu_container_fragment, MenuFragment.newInstance())
            .commit()
    }

    private fun initMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container_fragment, MainFragment.newInstance())
            .commit()
    }

}