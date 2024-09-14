package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnToLoginPage.setOnClickListener {

                val username = binding.username.text.toString() // Wahhab
                val email = binding.email.text.toString() // ban..
                val phone = binding.phone.text.toString()
                val password = binding.password2.text.toString()

                val intent = Intent(this@MainActivity, LoginPage::class.java).apply {
                    putExtra(LoginPage.EXTRA_NAME, username)
                    putExtra(LoginPage.EXTRA_EMAIL, email)
                    putExtra(LoginPage.EXTRA_PHONE, phone)
                    putExtra(LoginPage.EXTRA_PASSWORD, password)
                }
                startActivity(intent)
            }

        }
    }

}