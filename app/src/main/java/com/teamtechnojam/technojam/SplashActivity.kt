package com.teamtechnojam.technojam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.teamtechnojam.technojam.util.Constants

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.myLooper()!!).postDelayed(
            {
                startActivity(
                    Intent(this@SplashActivity, LogInActivity::class.java)
                )
                finish();
            },
            Constants.DELAY_TIME
        )
    }
}