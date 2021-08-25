package com.service

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.service.Constants.CHANNEL_ID_1
import com.service.Constants.CHANNEL_ID_2

class AppController : Application() {


  override fun onCreate() {
    super.onCreate()

    createNotificationChannel()
  }

  private fun createNotificationChannel() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val notificationManager = getSystemService(NotificationManager::class.java)

      val notificationChannel =
        NotificationChannel(CHANNEL_ID_1, "Example Service Channel", NotificationManager.IMPORTANCE_DEFAULT)

      val notificationChannel2 =
        NotificationChannel(CHANNEL_ID_2, "Example Service Channel", NotificationManager.IMPORTANCE_HIGH)

      notificationManager.createNotificationChannel(notificationChannel)
      notificationManager.createNotificationChannel(notificationChannel2)
    }


  }
}