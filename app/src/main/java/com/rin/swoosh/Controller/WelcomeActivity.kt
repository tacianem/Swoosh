package com.rin.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rin.swoosh.R
import kotlinx.android.synthetic.main.activity_welcome.*

class
WelcomeActivity : AppCompatActivity() {

    val TAG = "WelcomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        Log.d(TAG, "${javaClass.simpleName}")
        startButton.setOnClickListener() {
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)

        }
    }
}
