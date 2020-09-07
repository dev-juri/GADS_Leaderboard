package com.oluwafemi.gadsleaderboard.ui.submission.dialogs

import android.app.Activity
import android.content.Intent
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

        val returnIntent = Intent()

        binding.closeBtn.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, returnIntent)
            finish()
        }

        binding.confirmationBtn.setOnClickListener {
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        this.setFinishOnTouchOutside(false)
    }
}