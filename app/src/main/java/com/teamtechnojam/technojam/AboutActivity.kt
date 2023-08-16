package com.teamtechnojam.technojam

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teamtechnojam.technojam.databinding.ActivityAboutBinding
import com.teamtechnojam.technojam.util.Constants.FACEBOOK_URL
import com.teamtechnojam.technojam.util.Constants.GITHUB_URL
import com.teamtechnojam.technojam.util.Constants.INSTAGRAM_URL
import com.teamtechnojam.technojam.util.Constants.LINKED_IN

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.ivGithub.setOnClickListener {
            openUrlInBrowser(GITHUB_URL)
        }
        binding.ivFacebook.setOnClickListener {
            openUrlInBrowser(FACEBOOK_URL)
        }

        binding.ivLinkedin.setOnClickListener {
            openUrlInBrowser(LINKED_IN)
        }

        binding.ivInstagram.setOnClickListener {
            openUrlInBrowser(INSTAGRAM_URL)
        }
    }

    private fun openUrlInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        browserIntent.setPackage("com.android.chrome")

        val packageManager = packageManager

        val chromeInfo =
            packageManager.resolveActivity(browserIntent, PackageManager.MATCH_DEFAULT_ONLY)
        val isChromeInstalled = chromeInfo != null

        if (isChromeInstalled) {
            startActivity(browserIntent)
        } else {
            startActivity(intent)
        }
    }
}