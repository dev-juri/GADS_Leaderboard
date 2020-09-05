package com.oluwafemi.gadsleaderboard.ui.submission.dialogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oluwafemi.gadsleaderboard.R
import com.oluwafemi.gadsleaderboard.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_confirmation)

        binding.closeBtn.setOnClickListener {
            finish()
        }

        binding.confirmationBtn.setOnClickListener {
            setResult(200)
            finish()
        }

        this.setFinishOnTouchOutside(false)
    }
}