package com.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class BackgroundService : Service() {

  private val TAG = "BackgroundService"

  override fun onBind(intent: Intent?): IBinder? = null

  init {
    Log.i(TAG, " service is running")
  }

  override fun onCreate() {
    super.onCreate()
    Log.i(TAG, "onCreate: ")
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val data = intent?.getStringExtra("input")
    data?.let {
      Log.i(TAG, "onStartCommand: $data  ${Thread.currentThread().name}")
    }

    return START_NOT_STICKY
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(TAG, "onDestroy: ")
  }
}