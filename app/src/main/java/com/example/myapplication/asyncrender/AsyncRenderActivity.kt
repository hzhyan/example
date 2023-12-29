package com.example.myapplication.asyncrender

import android.os.Bundle
import android.os.HandlerThread
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import com.example.myapplication.databinding.LayoutAsyncRenderBinding

class AsyncRenderActivity: AppCompatActivity() {

    private val binding by lazy {
        LayoutAsyncRenderBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.renderBtn.setOnClickListener {
            asyncRender()
        }
    }

    private fun asyncRender() {
        val thread = object : HandlerThread("") {
            override fun onLooperPrepared() {
                super.onLooperPrepared()
                binding.renderBtn
                val textView = TextView(this@AsyncRenderActivity)
                textView.text = "这是一个测试"
                textView.invalidate()
                val bitmap = textView.drawToBitmap()
            }
        }
        thread.start()
    }

}

