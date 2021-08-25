package com.service

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyJobIntentService : JobIntentService() {

  private val TAG = "MyJobIntentService"

  companion object {

    private val JOB_ID = 2

    fun startWork(context: Context, intent: Intent) {
      enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
    }
  }

  override fun onHandleWork(intent: Intent) {
    val input = intent.getStringExtra("input")
    input?.let {
      for (i in 1..100) {
        Thread.sleep(1000)
        Log.i(TAG, "onHandleWork: $i $input ${Thread.currentThread().name}")
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(TAG, "onDestroy: ")
  }

}