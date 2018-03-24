package com.rin.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.rin.swoosh.Model.Player
import com.rin.swoosh.R
import com.rin.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        nextButton.setOnClickListener() {
            nextButtonClicked()
        }

        menToggleButton.setOnClickListener() {
            menTuggleClicked()
        }

        womenToggleButton.setOnClickListener() {
            womenTuggleClicked()
        }

        coedToggleButton.setOnClickListener() {
            coedTuggleClicked()
        }
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
            //it gets info of league and skill selected previously back to the new orientation!
        }
    }

    fun menTuggleClicked() {
        womenToggleButton.isChecked = false
        coedToggleButton.isChecked = false

        player.league = "men"
    }

    fun womenTuggleClicked() {
        menToggleButton.isChecked = false
        coedToggleButton.isChecked = false

        player.league = "women"
    }

    fun coedTuggleClicked() {
        menToggleButton.isChecked = false
        womenToggleButton.isChecked = false

        player.league = "co-ed"
    }

    fun nextButtonClicked() {
        if (player.league.isNotEmpty()) {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Select a league!", Toast.LENGTH_SHORT).show()
        }
    }


}
