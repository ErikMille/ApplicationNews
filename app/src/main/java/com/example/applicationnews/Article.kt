package com.example.applicationnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.squareup.picasso.Picasso
import android.net.Uri
import com.google.android.material.snackbar.Snackbar

class Article : AppCompatActivity() {
    private var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras

        if (extras == null) {
            Log.d("Activities", "oops no extras on the intent")
            return
        }
        val titleView = findViewById<TextView>(R.id.title)
        val textView = findViewById<TextView>(R.id.text)
        val urlView = findViewById<TextView>(R.id.source)
        val imageView = findViewById<ImageView>(R.id.icon)

        this.url = extras.getString("url")
        val imageUrl = extras.getString("imageUrl")

        titleView.text = extras.getString("title")
        textView.text = extras.getString("description")
        urlView.text = this.url

        Picasso
            .get()
            .load(extras.getString("imageUrl"))
            .into(imageView)
    }

    fun toSource(view: View) {
        val snackbar = Snackbar.make(view, this.url.toString(), Snackbar.LENGTH_LONG)
        snackbar.show()

        try {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(this.url.toString()))
            startActivity(urlIntent)
        } catch (e: Exception) {
            Log.i("Activities", "Null input")
        }
    }

}