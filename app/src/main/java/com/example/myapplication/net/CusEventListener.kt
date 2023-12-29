package com.example.myapplication.net

import android.util.Log
import okhttp3.Call
import okhttp3.Connection
import okhttp3.EventListener
import okhttp3.Protocol
import java.net.InetSocketAddress
import java.net.Proxy

class CusEventListener: EventListener() {

    override fun connectionAcquired(call: Call, connection: Connection) {
        super.connectionAcquired(call, connection)
        Log.d("yanshuang", "connectionAcquired ${connection.hashCode()}")
    }

    override fun connectionReleased(call: Call, connection: Connection) {
        super.connectionReleased(call, connection)
        Log.d("yanshuang", "connectionReleased ${connection.hashCode()}")
    }

    override fun connectStart(call: Call, inetSocketAddress: InetSocketAddress, proxy: Proxy) {
        super.connectStart(call, inetSocketAddress, proxy)
        Log.d("yanshuang", "connectStart")
    }

    override fun connectEnd(call: Call, inetSocketAddress: InetSocketAddress, proxy: Proxy, protocol: Protocol?) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol)
        Log.d("yanshuang", "connectEnd")
    }

}