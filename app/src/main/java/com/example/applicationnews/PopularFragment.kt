package com.example.applicationnews

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.error.ANError

import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray

import com.androidnetworking.interfaces.JSONObjectRequestListener

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PopularFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PopularFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val imageModelArrayList = populateList()
        val imageModelArrayList = get_news_from_api()
        val recyclerView = view.findViewById(R.id.my_recycler_view_popular) as RecyclerView// Bind to the recyclerview in the layout

        val layoutManager = LinearLayoutManager(activity) // Get the layout manager
        recyclerView.layoutManager = layoutManager
        val mAdapter = ForYouAdapter(imageModelArrayList)
        recyclerView.adapter = mAdapter
    }

    private fun populateList(): ArrayList<CardModel> {
        val list = ArrayList<CardModel>()
        val myImageList = arrayOf(R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship, R.drawable.ship)
        val myImageNameList = arrayOf(R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header, R.string.lorem_ipsum_header)
        val myImageTextList = arrayOf(R.string.lorem_ipsum_popular,R.string.lorem_ipsum_popular,R.string.lorem_ipsum,R.string.lorem_ipsum,R.string.lorem_ipsum,R.string.lorem_ipsum,R.string.lorem_ipsum,R.string.lorem_ipsum,R.string.lorem_ipsum,R.string.lorem_ipsum)

        for (i in 0..9) {
            val imageModel = CardModel()
            imageModel.setNames(getString(myImageNameList[i]))
            imageModel.setTexts(getString(myImageTextList[i]))
            imageModel.setImages(myImageList[i])
            list.add(imageModel)
        }
        return list
    }

    public fun get_news_from_api(): ArrayList<CardModel>{
        val list = ArrayList<CardModel>()

        AndroidNetworking.get("https://newsapi.org/v2/top-headlines")
            .addQueryParameter("country", "in")
            .addQueryParameter("apiKey", R.string.apiKeyNewsAPI.toString())
            .addHeaders("token", "1234")
            .setTag("test")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    try {
                        val articles = response.getJSONArray("articles")

                        for (j in 0 until articles.length()) {
                            val article = articles.getJSONObject(j)

                            val currentArticle = CardModel()

                            val author = article.getString("author")
                            val title = article.getString("title")
                            val description = article.getString("description")
                            val url = article.getString("url")
                            val urlToImage = article.getString("urlToImage")
                            val publishedAt = article.getString("publishedAt")
                            val content = article.getString("content")

                            // setting the values of the ArticleModel
                            // using the set methods
                            currentArticle.setAuthor(author)
                            currentArticle.setNames(title)
//                            currentArticle.setDescription(description)
                            currentArticle.setUrl(url)
                            currentArticle.setUrlToImage(urlToImage)
                            currentArticle.setPublishedAt(publishedAt)
                            currentArticle.setTexts(content)

                            // adding an article to the articles List
                            list.add(currentArticle)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onError(error: ANError) {
                    //
                }
            })
        return list
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PopularFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PopularFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}