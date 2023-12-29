package com.example.myapplication

import android.os.Trace
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KotlinTest {

    fun loadData() {
        Trace.beginSection("loadData")
        Log.d("TAG", "0000000")
        Thread.sleep(1000)
        Trace.endSection()
        GlobalScope.launch {
            Trace.beginSection("load_launch")
            Thread.sleep(1000)
            Log.d("TAG", "1111")
            Trace.endSection()
            load()
            Log.d("TAG", "333333")
        }
        Log.d("TAG", "99999999")
    }

    private fun th() {}

    suspend fun load(): String {
        val result = withContext(Dispatchers.IO) {
            Trace.beginSection("load_sleep")
            Thread.sleep(1000)
            Log.d("TAG", "ssssss")
            val count = System.currentTimeMillis()
            Trace.endSection()
            return@withContext ("tt$count")
        }
        return result
    }


}