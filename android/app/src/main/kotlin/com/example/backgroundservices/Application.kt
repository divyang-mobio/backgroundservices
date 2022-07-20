package com.example.backgroundservices

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import io.flutter.app.FlutterApplication

class Application : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("message" , "message" ,NotificationManager.IMPORTANCE_HIGH)
            val manager = getSystemService(NotificationManager::class.java).cancelAll()
//            manager.createNotificationChannel(channel)
        }
    }
}