package com.oluwafemi.gadsleaderboard.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.oluwafemi.gadsleaderboard.R
import com.oluwafemi.gadsleaderboard.adapter.PagerAdapter
import com.oluwafemi.gadsleaderboard.databinding.ActivityMainBinding
import com.oluwafemi.gadsleaderboard.ui.submission.SubmissionActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewPager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        viewPager = binding.pager
        val tabLayout = binding.tabLayout

        val tabTitle = arrayListOf(getString(R.string.learning_leaders), getString(
            R.string.skill_leaders
        ))

        val pagerAdapter = PagerAdapter(this)

        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        binding.submitButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SubmissionActivity::class.java)
            startActivity(intent)
        }

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