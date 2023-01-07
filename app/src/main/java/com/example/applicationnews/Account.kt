package com.example.applicationnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val imageModelArrayList = populateList()
//
        val recyclerView = findViewById(R.id.my_recycler_view_interests) as RecyclerView// Bind to the recyclerview in the layout

        val layoutManager = LinearLayoutManager(this) // Get the layout manager
        recyclerView.layoutManager = layoutManager
        val mAdapter = InterestsRecyclerAdapter(imageModelArrayList)
        recyclerView.adapter = mAdapter
    }

    private fun populateList(): ArrayList<CardModel> {
        val list = ArrayList<CardModel>()

        val myImageTextList = arrayOf(R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header)

        for (i in 0..9) {
            val imageModel = CardModel()
            imageModel.setTexts(getString(myImageTextList[i]))
            list.add(imageModel)
        }
        return list
    }
}