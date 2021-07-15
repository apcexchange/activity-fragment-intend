package com.example.myactivityfirstapp


import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var nextButton: Button
    var portraitCount = 0
    var landscapeCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState != null){
            landscapeCount = savedInstanceState.getInt("landscapeCount")
            portraitCount = savedInstanceState.getInt("portraitCount")
        }
        nextFragmentButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("landscapeCount", landscapeCount)
        outState.putInt("portraitCount", portraitCount)
    }



    override fun onStart() {
        super.onStart()
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            landscapeCount += 1
            secondTextView.text = "this is Landscape  $landscapeCount"
        } else if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            portraitCount ++
            secondTextView.text = "this is portrait  $portraitCount"
        }

    }

    override fun onResume() {
        super.onResume()
        "App is on resume state".also { firstTextView.text = it }
    }

    override fun onPause() {
        super.onPause()
        "App is on pause State".also { firstTextView.text = it }
    }

    override fun onStop() {
        super.onStop()
        "App is on stop State".also { firstTextView.text = it }
    }

    override fun onDestroy() {
        super.onDestroy()
        " App is on destroy state".also { firstTextView.text = it }
    }

    override fun onRestart() {
        super.onRestart()
        "App is on restart state".also { firstTextView.text = it }
    }
}