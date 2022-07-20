package com.example.backgroundservices

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat


class Notification : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val builder = NotificationCompat.Builder(this, "message")
                .setContentText("Background Service Test")
                .setContentTitle("Background Service Test")
                .setSmallIcon(R.drawable.launch_background)
                .setAutoCancel(true)

            manager.notify(1, builder.build())
//            startForeground(1,builder.build())
//            stopForeground(false)
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("error")
    }
}
