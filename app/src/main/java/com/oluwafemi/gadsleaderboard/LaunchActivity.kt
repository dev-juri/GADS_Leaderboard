package com.oluwafemi.gadsleaderboard

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import java.util.*

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        Timer().schedule(@RequiresApi(Build.VERSION_CODES.N)
        object : TimerTask() {
            override fun run() {
                val intent = Intent(this@LaunchActivity, BoardActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 4000L)
    }
}