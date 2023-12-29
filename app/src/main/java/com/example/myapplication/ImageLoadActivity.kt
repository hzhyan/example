package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.databinding.LayoutImageLoadBinding

class ImageLoadActivity : AppCompatActivity() {

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, ImageLoadActivity::class.java))
        }
    }

    private val binding by lazy {
        LayoutImageLoadBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loadBtn.setOnClickListener {
            Glide.with(binding.imageView)
                    .load("https://manhua.acimg.cn/operation/0/20_17_18_d8e195d2b1edc2c13b1b557d1e8dd8e1_1700471931046.jpg/0")
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(binding.imageView)
        }

        binding.loadBtn.post {  }
    }

}