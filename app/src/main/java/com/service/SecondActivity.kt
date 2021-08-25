package com.service

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.service.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

  private lateinit var binding: ActivitySecondBinding
  private lateinit var boundService: BoundService
  private var isBound = false
  private val TAG = "SecondActivity"
  private lateinit var myBinder: BoundService.MyBinder;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySecondBinding.inflate(layoutInflater)
    setContentView(binding.root)

    initViews()
  }

  private fun initViews() {
    binding.btStartBound.setOnClickListener {
      Intent(this, BoundService::class.java).also {
        bindService(it, serviceConnection, BIND_AUTO_CREATE)
        startService(it)
      }
    }

    binding.btStopBound.setOnClickListener {
      Intent(this, BoundService::class.java).also {
        if (myBinder != null) {
          unbindService(serviceConnection)
        }
      }
    }

    binding.btGetNumber.setOnClickListener {
      Log.i(TAG, "initViews: " + boundService.getRandomNumber())
    }

  }

  private val serviceConnection: ServiceConnection = object : ServiceConnection {

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
      isBound = true
      myBinder = service as BoundService.MyBinder
      boundService = myBinder.getService()

    }

    override fun onServiceDisconnected(name: ComponentName?) {
      isBound = false
    }

  }

}