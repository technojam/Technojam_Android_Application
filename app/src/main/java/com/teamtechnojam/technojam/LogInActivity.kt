package com.teamtechnojam.technojam

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teamtechnojam.technojam.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private lateinit var userName: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignUp.setOnClickListener {
            goToSignUpActivity()
        }

        binding.btnLogin.setOnClickListener {
            loginUser()
        }

        binding.tvForgotPassword.setOnClickListener {
            goToForgotPasswordActivity()
        }


    }

    private fun goToForgotPasswordActivity() {
        startActivity(Intent(this@LogInActivity, ForgotPasswordActivity::class.java))
    }

    private fun loginUser() {
        userName = binding.etUserName.text.toString();
        password = binding.etUserPassword.text.toString()

        if (userName.isEmpty()) {
            Toast.makeText(this@LogInActivity, "User Name can't be empty!!", Toast.LENGTH_SHORT)
                .show()
        } else if (password.isEmpty()) {
            Toast.makeText(this@LogInActivity, "Please enter your password", Toast.LENGTH_SHORT)
                .show()
        } else {
            verifyUser(userName, password)
        }
    }

    private fun verifyUser(userName: String, password: String) {

        if (userName == "TJ" && password == "TJ@123") {
            startActivity(Intent(this@LogInActivity, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(
                this@LogInActivity,
                "Wrong User Name or Password!! please try again.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun goToSignUpActivity() {
        startActivity(Intent(this@LogInActivity, SignUpActivity::class.java))
    }
}