package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LayoutMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        LayoutMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loadImageBtn.setOnClickListener {
            ImageLoadActivity.launch(this@MainActivity)
        }

        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        startActivity(intent)
    }
}