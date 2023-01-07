package com.example.applicationnews.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.applicationnews.ForYouFragment
import com.example.applicationnews.PopularFragment
import com.example.applicationnews.SearchFragment

class TabAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(index: Int): Fragment {
        when (index) {
            0 -> return ForYouFragment()
            1 -> return PopularFragment()
            2 -> return SearchFragment()
        }
        return ForYouFragment()
    }

    // get item count - equal to number of tabs
    override fun getItemCount(): Int
    {
        return 3
    }
}