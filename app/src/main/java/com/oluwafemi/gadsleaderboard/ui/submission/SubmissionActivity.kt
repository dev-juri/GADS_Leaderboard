package com.oluwafemi.gadsleaderboard.ui.submission

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submission)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        binding.submitBtn.setOnClickListener {
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val emailAddress = binding.emailAddress.text.toString()
            val submissionLink = binding.githubLink.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || submissionLink.isEmpty()) {
                Toast.makeText(this, "No field should be left blank", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                Toast.makeText(this, "Please input a correct email", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@SubmissionActivity, ConfirmationActivity::class.java)
                startActivityForResult(intent, 200)
            }
        }


        setSupportActionBar(binding.submissionToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.submissionToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val alertDialog = AlertDialog.Builder(this, R.style.DialogActivity)

        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val emailAddress = binding.emailAddress.text.toString()
        val submissionLink = binding.githubLink.text.toString()

        if (requestCode == 200) {
            if (resultCode == Activity.RESULT_OK) {
                LeaderboardAPI.submissionService.codeSubmission(
                    emailAddress,
                    firstName,
                    lastName,
                    submissionLink
                )
                    .enqueue(object : Callback<Void> {
                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            alertDialog.setView(
                                View.inflate(
                                    this@SubmissionActivity,
                                    R.layout.failure_layout,
                                    null
                                )
                            )
                            alertDialog.create()
                            alertDialog.show()
                            Log.i(
                                "Submission",
                                "Submission Error: $t"
                            )
                        }

                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            binding.firstName.setText("")
                            binding.lastName.setText("")
                            binding.emailAddress.setText("")
                            binding.githubLink.setText("")

                            alertDialog.setView(
                                View.inflate(
                                    this@SubmissionActivity,
                                    R.layout.success_layout,
                                    null
                                )
                            )
                            alertDialog.create()
                            alertDialog.show()

                            Log.i(
                                "Submission",
                                "Request Code : $resultCode Submission Successful for Mr $firstName $lastName with " +
                                        "email address $emailAddress and submission link $submissionLink"
                            )
                        }

                    })
            }
        }
    }

}