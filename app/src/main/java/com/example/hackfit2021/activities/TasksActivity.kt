package com.example.hackfit2021.activities

import android.content.Intent
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackfit2021.R
import kotlinx.android.synthetic.main.activity_tasks.*

class TasksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        breathing_activity_card.setOnClickListener {
            val intent = Intent(this,BreathingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}