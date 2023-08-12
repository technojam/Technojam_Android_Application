package com.teamtechnojam.technojam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teamtechnojam.technojam.databinding.ActivityOurAchievementsBinding

class OurAchievementsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOurAchievementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOurAchievementsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}