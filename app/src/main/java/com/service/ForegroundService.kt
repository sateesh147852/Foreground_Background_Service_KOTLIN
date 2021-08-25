package com.service

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.service.Constants.CHANNEL_ID_2

class ForegroundService : Service() {

  private val TAG = "ForegroundService"
  private var data: String = "ForegroundService"

  init {
    Log.i(TAG, ": init ")
  }

  override fun onCreate() {
    super.onCreate()
    Log.i(TAG, "onCreate: ")
  }

  override fun onBind(intent: Intent?): IBinder? = null

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    data = intent?.getStringExtra("input")!!

    val intent = Intent(this, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

    val notification = NotificationCompat.Builder(this, CHANNEL_ID_2)
      .setContentText("ForegroundService")
      .setContentTitle(data)
      .setSmallIcon(R.mipmap.ic_launcher)
      .setContentIntent(pendingIntent)
      .build()

    startForeground(2, notification)

    Log.i(TAG, "onStartCommand: ${Thread.currentThread().name}")

    return START_STICKY
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(TAG, "onDestroy: ")
  }
}