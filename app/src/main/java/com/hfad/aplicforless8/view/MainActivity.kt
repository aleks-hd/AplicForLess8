package com.hfad.aplicforless8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.aplicforless8.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMenuFragment()
        initMainFragment()

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