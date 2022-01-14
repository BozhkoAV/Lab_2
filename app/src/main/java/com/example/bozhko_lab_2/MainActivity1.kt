package com.example.bozhko_lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.i("callback_onCreate", "CREATED")
    }

    override fun onStart() {
        super.onStart()
        Log.i("callback_onStart", "STARTED")
    }

    override fun onResume() {
        super.onResume()
        Log.i("callback_onResume", "RESUMED")
    }

    override fun onPause() {
        super.onPause()
        Log.i("callback_onPause", "PAUSED")
    }

    override fun onStop() {
        super.onStop()
        Log.i("callback_onStop", "STOPPED")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("callback_onRestart", "onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("callback_onDestroy", "DESTROYED")
    }


}