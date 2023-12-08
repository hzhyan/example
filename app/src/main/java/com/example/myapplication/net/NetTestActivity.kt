package com.example.myapplication.net

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LayoutNetworkTestBinding

class NetTestActivity: AppCompatActivity() {

    private val binding by lazy {
        LayoutNetworkTestBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.launchBtn.setOnClickListener {
            NetManager.doRequest()
        }

    }

}