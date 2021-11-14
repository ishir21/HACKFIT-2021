package com.example.hackfit2021.activities

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.hackfit2021.R
import kotlinx.android.synthetic.main.music_player_activity.*
import android.widget.Toast

import android.media.AudioManager
import android.widget.Button
import java.io.IOException


class MusicActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    private lateinit var btnPlayAudio : Button
    val random = (0..5).random()
    private lateinit var mp: MediaPlayer
    private var totalTime: Int = 0
    var url: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.music_player_activity)

        mp = MediaPlayer.create(this, R.raw.om)
        mp.setVolume(0.5f, 0.5f)
        totalTime = mp  .duration
        btnPlayAudio = findViewById(R.id.playBtn)
        btnPlayAudio.setOnClickListener{
            playAudio()
        }
        // Position Bar
        positionBar.max = totalTime
        positionBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) {
                        mp.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        url = arrayListOf(
            "https://files.musopen.org/recordings/7f09f742-26c7-47ba-b735-2d87502665a7.mp3?filename=Nocturne+in+B+major,+Op.+9+no.+3.mp3&preview",
            "https://files.musopen.org/recordings/c8c20e40-b44b-4805-b3cf-f10e1c8e8a83.mp3?filename=Nocturne+in+E+flat+major,+Op.+9+no.+2.mp3&preview",
            "https://files.musopen.org/recordings/8476ae47-3751-4a07-a6db-a602e9dc5ffd.mp3?filename=Nocturne+in+B+flat+minor,+Op.+9+no.+1.mp3&preview",
            "https://files.musopen.org/recordings/4689d506-fb06-439a-878b-0a80e9722084.mp3?filename=Paul+Pitman+-+Moonlight+Sonata,+Op.+27+No.+2+-+I.+Adagio+sostenuto.mp3&preview",
            "https://files.musopen.org/recordings/abf0c677-9f10-4595-a158-1a76ccdbbeb3.mp3?%22filename=Ballade+no.+1+in+G+minor,+Op.+23.mp3&preview",
            "https://files.musopen.org/recordings/20533789-3e54-42bf-b720-e95df0e9f7fc.mp3?filename=Etude+Op.+25+no.+7+in+C+sharp+minor-+%27Cello%27.mp3&preview"
        )
        // Thread
        Thread(Runnable {
            while (true) {
                try {
                    val msg = Message()
                    msg.what = mp.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                }
            }
        }).start()
    }

    @SuppressLint("HandlerLeak")
    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what

            // Update positionBar
            positionBar.progress = currentPosition

            // Update Labels
            var elapsedTime = createTimeLabel(currentPosition)
            elapsedTimeLabel.text = elapsedTime

            var remainingTime = createTimeLabel(totalTime - currentPosition)
            remainingTimeLabel.text = "-$remainingTime"
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

    fun playBtnClick(v: View) {
//        playAudio()
        if (mp.isPlaying) {
            // Stop
            mp.pause()
            playBtn.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)

        } else {
            // Start
            mp.start()
            playBtn.setBackgroundResource(R.drawable.ic_baseline_pause_24)
        }
    }

    fun nextBtnClick(v: View) {
        mp.stop();
        mp.reset();
        mp = MediaPlayer.create(this, R.raw.om)
        mp.start();
    }
    fun loopBtnClick(v: View) {
        mp.isLooping = true
    }
    private fun playAudio(){
//        val audioURL = "https://files.musopen.org/recordings/8476ae47-3751-4a07-a6db-a602e9dc5ffd.mp3?filename=Nocturne+in+B+flat+minor,+Op.+9+no.+1.mp3"
        mediaPlayer =  MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try{
            mediaPlayer!!.setDataSource(url[random])
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        }
        catch(e : IOException){
            e.printStackTrace()
        }
        Toast.makeText(this,"Audio started playing...", Toast.LENGTH_LONG).show()
    }
    private fun pauseAudio(){
        if(mediaPlayer!!.isPlaying){
            mediaPlayer!!.stop()
            mediaPlayer!!.reset()
            mediaPlayer!!.release()
        }
        else{
            Toast.makeText(this,"Audio has not played", Toast.LENGTH_LONG).show()
        }
    }
}
