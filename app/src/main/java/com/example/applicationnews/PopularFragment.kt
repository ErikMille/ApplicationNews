package com.example.applicationnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val imageModelArrayList = populateList()
//
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