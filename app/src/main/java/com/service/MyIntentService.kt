package com.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

  init {
    instance = this
    isRunning = true
  }

  companion object {
    private lateinit var instance: MyIntentService
    var isRunning = false

    fun stopService() {
      Log.i("MyIntentService", "Service is stopping")
      isRunning = false
      instance.stopSelf()
    }
  }

  override fun onHandleIntent(intent: Intent?) {
    val input = intent?.getStringExtra("input")
    input?.let {
      Log.i("MyIntentService ", input + "  "+ Thread.currentThread().name)
    }
    Thread.sleep(2500)
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i("MyIntentService", "onDestroy: ")
  }

}