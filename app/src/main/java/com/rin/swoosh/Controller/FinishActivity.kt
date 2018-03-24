package com.rin.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rin.swoosh.Model.Player
import com.rin.swoosh.R
import com.rin.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        searchingText.text = getString(R.string.searching, player.league, player.skill)

    }
}
