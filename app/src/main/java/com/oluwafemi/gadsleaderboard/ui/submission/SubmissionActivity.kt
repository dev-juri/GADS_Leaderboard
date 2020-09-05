package com.oluwafemi.gadsleaderboard.ui.submission

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oluwafemi.gadsleaderboard.R
import com.oluwafemi.gadsleaderboard.databinding.ActivitySubmissionBinding

class SubmissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submission)

       binding.submissionToolbar.setNavigationOnClickListener {
           finish()
       }
        setSupportActionBar(binding.submissionToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

}