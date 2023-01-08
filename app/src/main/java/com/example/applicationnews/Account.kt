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
        val recyclerView = findViewById(R.id.my_recycler_view_interests) as RecyclerView

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val mAdapter = InterestsRecyclerAdapter(imageModelArrayList)
        recyclerView.adapter = mAdapter
    }

    private fun populateList(): ArrayList<InterestModel> {
        val list = ArrayList<InterestModel>()

        val myImageTextList = arrayOf(R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header)

        for (i in 0..9) {
            val imageModel = InterestModel()
            imageModel.setTexts(getString(myImageTextList[i]))
            list.add(imageModel)
        }
        return list
    }
}