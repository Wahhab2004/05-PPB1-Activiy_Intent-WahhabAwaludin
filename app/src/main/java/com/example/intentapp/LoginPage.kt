package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding : ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_NAME) ?: "Guest"
        val email = intent.getStringExtra(EXTRA_EMAIL) ?: "No Email"
        val phone = intent.getStringExtra(EXTRA_PHONE) ?: "No Phone"
        val password = intent.getStringExtra(EXTRA_PASSWORD) ?: "No Password"

        with(binding) {
            btnToHomePage.setOnClickListener {

                val inputUsername = binding.username.text.toString()
                val inputPassword = binding.password.text.toString()

                if (inputUsername == username && inputPassword == password) {
                    val intent = Intent(this@LoginPage, HomePage::class.java).apply {
                        putExtra(HomePage.EXTRA_NAME, username)
                        putExtra(HomePage.EXTRA_EMAIL, email)
                        putExtra(HomePage.EXTRA_PHONE, phone)
                    }
                    startActivity(intent)
                } else {

                    Toast.makeText(this@LoginPage, "Error: Username atau password salah.", Toast.LENGTH_LONG).show()
                    println("Error: Username atau password salah.")

                }
            }
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }
}
