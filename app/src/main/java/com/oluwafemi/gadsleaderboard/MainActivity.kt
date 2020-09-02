package com.oluwafemi.gadsleaderboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.oluwafemi.gadsleaderboard.adapter.PagerAdapter
import com.oluwafemi.gadsleaderboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewPager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewPager = binding.pager
        val tabLayout = binding.tabLayout

        val tabTitle = arrayListOf(getString(R.string.learning_leaders), getString(R.string.skill_leaders))

        val pagerAdapter = PagerAdapter(this)

        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = 0
        }
    }
}