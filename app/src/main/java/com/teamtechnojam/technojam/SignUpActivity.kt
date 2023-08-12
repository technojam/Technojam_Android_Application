package com.teamtechnojam.technojam

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teamtechnojam.technojam.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    private lateinit var userName: String
    private lateinit var phoneNumber: String
    private lateinit var userMail: String
    private lateinit var password: String
    private lateinit var confirmPassword: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView((binding.root))


        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.tvLogin.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnSignUp.setOnClickListener {
            verifyInput()
        }

    }

    private fun verifyInput() {
        userName = binding.etUserName.text.toString()
        phoneNumber = "+91" + binding.etPhoneNo.text.toString()
        userMail = binding.etEmail.text.toString()
        password = binding.etPassword.text.toString()
        confirmPassword = binding.etConformPassword.text.toString()

        if (userName.isEmpty() || phoneNumber.isEmpty() || userMail.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this@SignUpActivity, "All fields are required!", Toast.LENGTH_SHORT)
                .show()
        } else if (password != confirmPassword) {
            Toast.makeText(
                this@SignUpActivity,
                "Password didn't match, Please try again.",
                Toast.LENGTH_SHORT
            ).show()
        } else if (password.length < 8) {
            Toast.makeText(this@SignUpActivity, "Password too short!!", Toast.LENGTH_SHORT)
                .show()
        } else {
            registerUser(userName, phoneNumber, userMail, password)
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun registerUser(
        userName: String,
        phoneNumber: String,
        userMail: String,
        password: String
    ) {
        Log.d("SIGNUPDONE", "registerUser: $userName $phoneNumber $userMail $password")
    }
}