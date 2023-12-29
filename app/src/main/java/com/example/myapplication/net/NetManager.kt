package com.example.myapplication.net

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

object NetManager {

    private val client by lazy {
        OkHttpClient.Builder().eventListener(CusEventListener()).build()
    }

    fun doRequest() {
        val request =
            Request.Builder().url("https://manhua.acimg.cn/manhua/0/07_16_18_b7f002e3af1fc51a3fb84f7c874f29db.jpg/0")
                    .build()
        val call = client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("yanshuang", "onFailure $e")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("yanshuang", "onResponse ${reList.size} $response")
                reList.add(response)
                callList.add(call)
                call.cancel()
//                call.cancel()
//                val bytes = response.body?.bytes()
//                Log.d("yanshuang", "onResponse bytes = ${bytes?.size}")
//                re = response
            }

        })
    }

    private var reList = arrayListOf<Response>()
    private var callList = arrayListOf<Call>()

    fun read() {
        Thread {
            for (re in reList) {
                val bytes = re?.body?.bytes()
                Log.d("yanshuang", "onResponseRead ${reList.indexOf(re)} bytes = ${bytes?.size}")
            }
        }.start()
    }

}