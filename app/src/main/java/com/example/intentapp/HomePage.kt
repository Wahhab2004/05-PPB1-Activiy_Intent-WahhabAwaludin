package com.example.intentapp

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding : ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_NAME) ?: "Guest"
        val email = intent.getStringExtra(EXTRA_EMAIL) ?: "No Email"
        val phone = intent.getStringExtra(EXTRA_PHONE) ?: "No Phone"

        binding.userPage.text = setColoredText("Welcome ", username, Color.BLUE)
        binding.emailPage.text = setColoredText("Your ", email, Color.BLUE, " has been activated")
        binding.phonePage.text = setColoredText("Your ", phone, Color.BLUE, " has been registered")

    }


    private fun setColoredText(startText: String, coloredText: String, color: Int, endText: String = ""): SpannableString {
        val fullText = startText + coloredText + endText
        val spannableString = SpannableString(fullText)
        val start = startText.length
        val end = start + coloredText.length

        spannableString.setSpan(ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        return spannableString
    }

    companion object  {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }


}