package com.oluwafemi.gadsleaderboard

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import java.util.*

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_launch)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@LaunchActivity, BoardActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000L)
    }
}