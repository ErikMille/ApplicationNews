package com.example.applicationnews

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.content.Intent

class InterestsRecyclerAdapter (private val imageModelArrayList: MutableList<InterestModel>) : RecyclerView.Adapter<InterestsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestsRecyclerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.interest, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: InterestsRecyclerAdapter.ViewHolder, position: Int) {
        val info = imageModelArrayList[position]

        holder.txtMsg.text = info.getTexts()
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var txtMsg = itemView.findViewById<View>(R.id.text) as TextView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val msg = txtMsg.text
            val snackbar = Snackbar.make(v, "$msg" + R.string.lorem_ipsum, Snackbar.LENGTH_LONG)
            snackbar.show()

            try {
                val intent = Intent(v.context, Article::class.java)
                v.context.startActivity(intent)
            } catch (e: Exception) {
                Log.i("Activities", "Null input")
            }
        }
    }
}