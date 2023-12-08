package com.example.myapplication.net

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

object NetManager {

    private val client by lazy {
        OkHttpClient.Builder().build()
    }

    fun doRequest() {
        val request = Request.Builder().url("https://raw.github.com/square/okhttp/master/README.md").build()
        val call = client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("yanshuang", "onFailure $e")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("yanshuang", "onResponse $response")
            }

        })
    }

}