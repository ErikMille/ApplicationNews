package com.example.applicationnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.koushikdutta.ion.Ion
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var list: ArrayList<CardModel>? = arrayListOf<CardModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = view.findViewById(R.id.search_bar) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                clearList()
                get_news_from_api(query)
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
//        populateList()
//        get_news_from_api()
    }

    private fun clearList(){
        this.list?.clear()
    }

    private fun get_news_from_api(query: String?) {
//        val query = "airplane"
        val url = "https://gnews.io/api/v4/search?q=${query}&token=" +"ab73f2546732982105a0ab74c77856f6"+ "&lang=en&country=us&max=10"

        Ion.with(this)
            .load(url)
            .asString()
            .setCallback{ex, result ->
                populateList(result)
            }
    }

    private fun populateList(result: String) {
        val articlesObj = JSONObject(result)
        val articlesArray = articlesObj.getJSONArray("articles")
        val myImageList = arrayOf(R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship)

        for (i in 0..9) {
            val imageModel = CardModel()
            imageModel.setNames(articlesArray.getJSONObject(i).getString("title"))
            imageModel.setTexts(articlesArray.getJSONObject(i).getString("content"))
            imageModel.setAuthor(articlesArray.getJSONObject(i).getString("title"))
            imageModel.setPublishedAt(articlesArray.getJSONObject(i).getString("publishedAt"))
            imageModel.setUrl(articlesArray.getJSONObject(i).getString("url"))
            imageModel.setDescription(articlesArray.getJSONObject(i).getString("description"))
            imageModel.setUrlToImage(articlesArray.getJSONObject(i).getString("image"))
            this.list?.add(imageModel)
        }
        render()
    }

    private fun render() {
//        val imageModelArrayList = this.list
        val recyclerView = view?.findViewById(R.id.my_recycler_view_search) as RecyclerView// Bind to the recyclerview in the layout
        recyclerView.removeAllViewsInLayout()
        val layoutManager = LinearLayoutManager(activity) // Get the layout manager
        recyclerView.layoutManager = layoutManager
        val mAdapter = this.list?.let { ForYouAdapter(it) }
        recyclerView.adapter = mAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}