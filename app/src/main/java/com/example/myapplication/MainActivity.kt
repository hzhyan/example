package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LayoutMainBinding
import com.example.myapplication.process.MainProcessActivity


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

//        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
//        startActivity(intent)



        binding.newThreadBtn.setOnClickListener {
//            testCreateBitmap()
            testCreateThread()
        }

        binding.testServiceBtn.setOnClickListener {
            TestServiceActivity.launch(this@MainActivity)
        }

        binding.testProcessBtn.setOnClickListener {
            startActivity(Intent(this, MainProcessActivity::class.java))
        }
    }

    val threadList = arrayListOf<Thread>()

    val bitmapList = arrayListOf<Bitmap>()

    private fun testCreateBitmap() {
        for (index in 0 .. 9) {
            // 创建空Bitmap对象
            val bitmap = Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888)
            bitmapList.add(bitmap)
        }
    }

    private fun testCreateThread() {
        for (index in 0..9999) {
            val runnable = object : Runnable {
                override fun run() {
                    (this as Object).apply {
                        synchronized(this) {
                            wait()
                        }
                    }
                }
            }
            Thread(runnable).apply {
                threadList.add(this)
                start()
            }
        }
    }

}