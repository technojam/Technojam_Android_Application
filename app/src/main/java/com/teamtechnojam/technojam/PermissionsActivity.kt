package com.teamtechnojam.technojam

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teamtechnojam.technojam.databinding.ActivityPermissionsBinding

class PermissionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPermissionsBinding
    private lateinit var proposalPersonName: String
    private lateinit var proposalEmail: String
    private lateinit var proposalDescription: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnSubmit.setOnClickListener {
            verifyData()
        }
    }

    private fun verifyData() {
        proposalPersonName = binding.etName.text.toString()
        proposalDescription = binding.etPlanDescription.text.toString()
        proposalEmail = binding.etEmail.text.toString()

        if (proposalPersonName.isEmpty() || proposalEmail.isEmpty() || proposalDescription.isEmpty()) {
            Toast.makeText(this@PermissionsActivity, "All fields are required", Toast.LENGTH_SHORT)
                .show()
        } else {
            Log.d(
                "TECHNOJAM_LOG",
                "verifyData: $proposalPersonName $proposalEmail $proposalDescription"
            )

            binding.doneAnimation.visibility = View.VISIBLE
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    onBackPressedDispatcher.onBackPressed()
                },
                2000L
            )

        }
    }
}