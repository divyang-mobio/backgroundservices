package com.example.backgroundservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import java.lang.UnsupportedOperationException

class BgService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext, "hello", Toast.LENGTH_LONG).show()
        return START_NOT_STICKY
    }

//    override fun onCreate() {
//        super.onCreate()
//        Toast.makeText(applicationContext, "hello", Toast.LENGTH_LONG).show()
//    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("error")
    }
}