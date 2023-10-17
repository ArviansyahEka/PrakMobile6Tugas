package com.example.prakmobile6tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prakmobile6tugas.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
val uname = intent.getStringExtra(MainActivity.uname)
            getusername.text = uname
        }
    }
}