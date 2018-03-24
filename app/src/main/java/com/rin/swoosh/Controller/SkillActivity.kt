package com.rin.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.rin.swoosh.Model.Player
import com.rin.swoosh.R
import com.rin.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)

        ballerToggleButton.setOnClickListener() {
            ballerTuggleClicked()
        }

        beginnerToggleButton.setOnClickListener() {
            beginnerTuggleClicked()
        }

        finishButton.setOnClickListener() {
            finishButtonClicked()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun ballerTuggleClicked() {
        beginnerToggleButton.isChecked = false
        player.skill = "baller"
    }

    fun beginnerTuggleClicked() {
        ballerToggleButton.isChecked = false
        player.skill = "beginner"
    }

    fun finishButtonClicked() {
        if (player.skill.isNotEmpty()) {
            val finishIntent = Intent(this, FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this, getString(R.string.select_skill), Toast.LENGTH_SHORT).show()
        }
    }

}
