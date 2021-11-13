package com.example.hackfit2021.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.hackfit2021.ChatBotActivity
import com.example.hackfit2021.MainActivity
import com.example.hackfit2021.R
import kotlinx.android.synthetic.main.activity_main.*


class MusicFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }
    override fun onResume() {
        super.onResume()

        val mainActivity = activity as MainActivity?
        mainActivity?.floatingactionbutton?.show()
        mainActivity?.floatingactionbutton?.setImageResource(R.drawable.bot_icon)
        mainActivity?.floatingactionbutton?.setOnClickListener {
            val intent = Intent(context, ChatBotActivity::class.java)
            startActivity(intent)
        }
    }
}