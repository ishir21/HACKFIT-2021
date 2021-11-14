package com.example.hackfit2021.activities

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.hackfit2021.R
import com.example.hackfit2021.model.BreathingViewModel
import kotlinx.android.synthetic.main.activity_breathing.*

class BreathingActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaPlayer2: MediaPlayer
    private lateinit var viewModel: BreathingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breathing)

        viewModel = ViewModelProvider(this).get(BreathingViewModel::class.java)

        viewModel.currentTimer.observe(this){time->
            timer_text.text = time.toString()
        }

        viewModel.timeDone.observe(this){timeDone->
            if(timeDone){
                closeActivity()
            }
        }

        stop_breating.setOnClickListener {
            viewModel.onTimeDone()
        }
        startPlaying()
    }

    private fun startPlaying() {
        mediaPlayer = MediaPlayer.create(this,R.raw.om)
        mediaPlayer.start()
    }

    private fun closeActivity() {
        viewModel.onTimeDoneFinish()
        mediaPlayer.stop()
        val intent = Intent(this,TasksActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        closeActivity()
    }


}