package com.example.bozhko_lab_2

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2_3 : AppCompatActivity() {
    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    var isWorking = true

    var backgroundThread = Thread {
        while (true) {
            if (isWorking) {
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.setText(getString(R.string.seconds, secondsElapsed++))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.continue_watch)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onStart() {
        super.onStart()
        isWorking = true
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        secondsElapsed = sharedPref.getInt(SECONDS_ELAPSED, secondsElapsed)
    }

    override fun onStop() {
        super.onStop()
        isWorking = false
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putInt(SECONDS_ELAPSED, secondsElapsed)
            apply()
        }
    }

    companion object {
        val SECONDS_ELAPSED = "secondsElapsed"
    }
}