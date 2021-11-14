package com.example.hackfit2021.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackfit2021.activities.ChatBotActivity
import com.example.hackfit2021.R
import com.example.hackfit2021.activities.MusicActivity

import com.example.hackfit2021.adapters.MusicAdapter

import com.example.hackfit2021.entities.Music
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_music.*
import com.example.hackfit2021.activities.MainActivity as MainActivity


class MusicFragment : Fragment() {
    private lateinit var newMusicRecyclerview: RecyclerView
    private lateinit var newMusicArrayList: ArrayList<Music>
    lateinit var musicimageId: Array<Int>
    lateinit var musicheading: Array<String>
    lateinit var playimage: Array<Int>

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

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        musicimageId = arrayOf(R.drawable.music_logo,
            R.drawable.music_logo,
            R.drawable.music_logo,
            R.drawable.music_logo,
            R.drawable.music_logo,
            R.drawable.music_logo,
            R.drawable.music_logo,
            R.drawable.music_logo,)
        musicheading = arrayOf(
            "Nocturne in B major ",
            "Nocturne in E flat major",
            "Nocturne in B flat minor",
            "Paul Pitman Moonlight Sonata",
            "Ballade no. 1 in G minor",
            " Etude Op. 25 no. 7 in C sharp minor",
            "Goldberg Variations BWV 988 13 - Variatio 12 Canone all Quarta",
            "Paul Pitman-Moonlight Sonata Op. 27 No. 2 - III. Presto"
        )
        playimage = arrayOf(R.drawable.play_logo,
            R.drawable.play_logo,
            R.drawable.play_logo,
            R.drawable.play_logo,
            R.drawable.play_logo,
            R.drawable.play_logo,
            R.drawable.play_logo,
            R.drawable.play_logo,)

        MusicRecycler.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            MusicRecycler.setHasFixedSize(true)
            newMusicArrayList = arrayListOf<Music>()
            getUserData()
//            adapter = MusicAdapter()
        }
    }

    private fun getUserData() {
        for (i in musicimageId.indices) {
            val music = Music(musicimageId[i], musicheading[i], playimage[i])
            newMusicArrayList.add(music)
        }
        var adapter = MusicAdapter(newMusicArrayList)
        MusicRecycler.adapter = adapter
        adapter.setOnMusicClickListener(object : MusicAdapter.onMusicClickListener {
            override fun onMusicClick(position: Int) {
                Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, MusicActivity::class.java)
                intent.putExtra("position",position)
                intent.putExtra("heading",musicheading[position])
                startActivity(intent)
//               intent.putExtra("heading",newMusicArrayList[position].musicTitle)
            }


        })
    }
}