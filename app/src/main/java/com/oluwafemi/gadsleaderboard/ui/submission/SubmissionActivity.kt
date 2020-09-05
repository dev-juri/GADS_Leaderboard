package com.oluwafemi.gadsleaderboard.ui.submission

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oluwafemi.gadsleaderboard.R
import com.oluwafemi.gadsleaderboard.databinding.ActivitySubmissionBinding
import com.oluwafemi.gadsleaderboard.network.LeaderboardAPI
import com.oluwafemi.gadsleaderboard.ui.submission.dialogs.ConfirmationActivity
import java.lang.Exception
import kotlin.properties.Delegates

class SubmissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submission)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.submissionToolbar.setNavigationOnClickListener {
            finish()
        }
        binding.submitBtn.setOnClickListener {
            val intent = Intent(this@SubmissionActivity, ConfirmationActivity::class.java)
            startActivityForResult(intent, 200)
        }


        setSupportActionBar(binding.submissionToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val emailAddress = binding.emailAddress.text.toString()
        val submissionLink = binding.githubLink.text.toString()

        if (requestCode == 200) {
            if (firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || submissionLink.isEmpty()) {
                Toast.makeText(this, "No field should be left blank", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                Toast.makeText(this, "Please input a correct email", Toast.LENGTH_SHORT).show()
            } else {
                try {/*
                    LeaderboardAPI.submissionService.codeSubmission(
                        emailAddress,
                        firstName,
                        lastName,
                        submissionLink
                    )*/

                    Log.i(
                        "Submission",
                        "Submission Successful for Mr $firstName $lastName with " +
                                "email address $emailAddress and submission link $submissionLink"
                    )
                } catch (e : Exception) {
                    Log.i(
                        "Submission",
                        "Submission Error: $e"
                    )
                }
            }
        } else {
            Log.i("Submission", "No request code, but working")
        }
    }

}