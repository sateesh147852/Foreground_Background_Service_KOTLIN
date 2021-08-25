package com.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    initViews()
  }

  private fun initViews() {

    binding.btStartBackground.setOnClickListener {

      Intent(this, BackgroundService::class.java).also {
        it.putExtra("input", binding.etName.text.toString())
        startService(it)
      }

    }

    binding.btStartForeground.setOnClickListener {

      Intent(this, ForegroundService::class.java).also {
        it.putExtra("input", binding.etName.text.toString())
        ContextCompat.startForegroundService(this, it)
      }
    }

    binding.btStartIntent.setOnClickListener {
      Intent(this, MyIntentService::class.java).also {
        it.putExtra("input", binding.etName.text.toString())
        startService(it)
      }

    }

    binding.btStartJobIntent.setOnClickListener {
      Intent(this, MyJobIntentService::class.java).also {
        it.putExtra("input", binding.etName.text.toString())
        MyJobIntentService.startWork(this, it)
      }
    }

    binding.btSecond.setOnClickListener {
      Intent(this,SecondActivity::class.java).also {
        startActivity(it)
      }
    }

  }
}