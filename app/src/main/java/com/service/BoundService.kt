package com.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

class BoundService : Service() {
  
  private val TAG = "BoundService"

  private val myBinder = MyBinder()

  companion object {
    private val random = Random()
  }

  override fun onCreate() {
    super.onCreate()
    Log.i(TAG, "onCreate: ")
  }

  override fun onBind(intent: Intent?): IBinder? {
    Log.i(TAG, "onBind: ")
    return myBinder
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    return START_STICKY
  }

  override fun onUnbind(intent: Intent?): Boolean {
    Log.i(TAG, "onUnbind: ")
    return super.onUnbind(intent)
  }

  override fun onRebind(intent: Intent?) {
    super.onRebind(intent)
  }

  public fun getRandomNumber(): Int {
    Log.i(TAG, "getRandomNumber: "+Thread.currentThread().name)
    return random.nextInt()
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(TAG, "onDestroy: ")
  }

  override fun onTaskRemoved(rootIntent: Intent?) {
    super.onTaskRemoved(rootIntent)
    stopSelf()
  }

  inner class MyBinder : Binder() {
    fun getService() : BoundService {
      return this@BoundService
    }

  }

}

