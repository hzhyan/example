package com.example.myapplication.process

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LayoutProcessTestBinding

class SubProcess2Activity: AppCompatActivity() {

    private val binding by lazy {
        LayoutProcessTestBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("yanshuang", "SubProcess2Activity onCreate")
        binding.launchBtn.setOnClickListener {
        }
    }

}