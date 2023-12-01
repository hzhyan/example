package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


private const val TAG = "yanshuang"
class TestService: Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "TestService@${hashCode()}: onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "TestService@${hashCode()}: onStartCommand $intent $flags $startId")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "TestService@${hashCode()}: onBind")
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "TestService@${hashCode()}: onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.d(TAG, "TestService@${hashCode()}: onDestroy")
        super.onDestroy()
    }


}