package com.example.applicationnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.applicationnews.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.pager)

        val tabTitles = resources.getStringArray(R.array.tabTitles)
        viewPager.adapter = TabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = tabTitles[0]
                1 -> tab.text = tabTitles[1]
                2 -> tab.text = tabTitles[2]
            }
        }.attach()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate((R.menu.toolbar_layout), menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun launchAccount(item: MenuItem) {
        try {
            val newIntent = Intent(this, Account::class.java)
            startActivity(newIntent)
        } catch (e: Exception) {
            Log.i("Activities", "Null input")
        }
    }

    fun launchArticle(view: View) {
        try {
            val newIntent = Intent(this, Article::class.java)
            startActivity(newIntent)
        } catch (e: Exception) {
            Log.i("Activities", "Null input")
        }
    }
}