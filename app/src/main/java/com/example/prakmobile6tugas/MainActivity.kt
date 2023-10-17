package com.example.prakmobile6tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prakmobile6tugas.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val uname = "uname"
        const val pass = "pass"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            viewPager.adapter = LoginFragment.TabAdapter(supportFragmentManager)
            tabLayout.setupWithViewPager(viewPager)

        }

    }
}