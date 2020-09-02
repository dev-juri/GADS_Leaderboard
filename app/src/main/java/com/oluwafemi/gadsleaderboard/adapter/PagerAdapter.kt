package com.oluwafemi.gadsleaderboard.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.oluwafemi.gadsleaderboard.ui.LearningFragment
import com.oluwafemi.gadsleaderboard.ui.SkillFragment

class PagerAdapter (fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LearningFragment()
            else -> SkillFragment()
        }
    }

}