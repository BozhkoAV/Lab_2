package com.example.bozhko_lab_2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2_2 : AppCompatActivity() {
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

        /*if (savedInstanceState != null) {
            with(savedInstanceState) {
                secondsElapsed = getInt(SECONDS_ELAPSED)
            }
        } else {
            secondsElapsed = 0
        }*/

        setContentView(R.layout.continue_watch)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onStart() {
        super.onStart()
        isWorking = true
    }

    override fun onStop() {
        super.onStop()
        isWorking = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt(SECONDS_ELAPSED, secondsElapsed)
        }

        super.onSaveInstanceState(outState)
    }

    companion object {
        val SECONDS_ELAPSED = "secondsElapsed"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.run {
            secondsElapsed = getInt(SECONDS_ELAPSED)
        }
    }
}