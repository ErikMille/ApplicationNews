package com.example.applicationnews

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.content.Intent
import com.squareup.picasso.Picasso


class ForYouAdapter (private val imageModelArrayList: MutableList<CardModel>) : RecyclerView.Adapter<ForYouAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.article_card, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = imageModelArrayList[position]

        Picasso
            .get()
            .load(info.getUrlToImage())
            .into(holder.imgView)

        holder.nameMsg.text = info.getNames()
        holder.txtMsg.text = info.getDescription()
        holder.info = info
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var imgView = itemView.findViewById<View>(R.id.icon) as ImageView
        var nameMsg = itemView.findViewById<View>(R.id.firstLine) as TextView
        var txtMsg = itemView.findViewById<View>(R.id.text) as TextView
        var info: CardModel? = CardModel()

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val msg = txtMsg.text
            val snackbar = Snackbar.make(v, "$msg" + R.string.lorem_ipsum, Snackbar.LENGTH_LONG)
            snackbar.show()

            imageModelArrayList

            try {
                val intent = Intent(v.context, Article::class.java)
                intent.putExtra("title", this.info?.getNames())
                intent.putExtra("description", this.info?.getDescription())
                intent.putExtra("url", this.info?.getUrl())
                intent.putExtra("imageUrl", this.info?.getUrlToImage())
                v.context.startActivity(intent)
            } catch (e: Exception) {
                Log.i("Activities", "Null input")
            }
        }
    }
}