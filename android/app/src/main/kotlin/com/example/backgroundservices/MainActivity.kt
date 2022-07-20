package com.example.backgroundservices

import android.content.Intent
import android.os.Build
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            "background"
        ).setMethodCallHandler { call, result ->
            if (call.method == "toastService") {
                val intent = Intent(this, BgService::class.java)
                startService(intent)
                result.success("toast Service ON")
            } else if (call.method == "notificationService") {
                val data = Intent(this, Notification::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(data)
                } else {
                    startService(data)
                }
                result.success("Notification Service ON")
            }
        }
    }
}
