package com.example.quoteappaakid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import com.example.quoteappaakid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds

    lateinit var myBtn:Button




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler().postDelayed({
            // Start your main activity after the splash timeout
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)

            // Close the splash activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}