package com.example.myapplication.process

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LayoutProcessTestBinding

class MainProcessActivity: AppCompatActivity() {

    private val binding by lazy {
        LayoutProcessTestBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("yanshuang", "MainProcessActivity onCreate")
        binding.launchBtn.setOnClickListener {
            this.startActivity(Intent(this, SubProcessActivity::class.java))
        }
    }

}