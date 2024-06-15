package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = NewsHeadlines()

        // Optionally, pass any extras from the intent to the fragment's arguments
        fragment.arguments = intent.extras

        // Replace the fragment container with the NewsHeadlines fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment) // Ensure R.id.fragmentContainerView exists in activity_main.xml
            .commit()

    }
}