package com.example.myapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LayoutTestServiceBinding
import java.util.Date

class TestServiceActivity : AppCompatActivity() {

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, TestServiceActivity::class.java))
        }
    }

    private val binding by lazy {
        LayoutTestServiceBinding.inflate(LayoutInflater.from(this))
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d("yanshuang", "onServiceConnected $name")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("yanshuang", "onServiceDisconnected $name")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startService.setOnClickListener {
            startService(Intent(this@TestServiceActivity, TestService::class.java).apply {
                putExtra("time", Date().toString())
            })
        }

        binding.bindService.setOnClickListener {
            bindService(
                Intent(this@TestServiceActivity, TestService::class.java),
                serviceConnection,
                Context.BIND_AUTO_CREATE
            )
        }

        binding.unbindService.setOnClickListener {
            unbindService(serviceConnection)
        }

        binding.stopService.setOnClickListener {
            stopService(Intent(this@TestServiceActivity, TestService::class.java))
        }

    }

}