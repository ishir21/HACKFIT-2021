package com.example.hackfit2021


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hackfit2021.Fragments.BlogsFragment
import com.example.hackfit2021.Fragments.DiaryListFragment
import com.example.hackfit2021.Fragments.HomeFragment
import com.example.hackfit2021.Fragments.MusicFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.menu.getItem(0).isCheckable = true
        setFragment(HomeFragment())
        bottomNavigationView.setOnItemSelectedListener { menu ->

            when (menu.itemId) {

                R.id.tab_home -> {
                    setFragment(HomeFragment())
                    true
                }

                R.id.tab_diary -> {
                    setFragment(DiaryListFragment())
                    true
                }

                R.id.tab_music_list -> {
                    setFragment(MusicFragment())
                    true
                }
                R.id.tab_blogs -> {
                    setFragment(BlogsFragment())
                    true
                }

                else -> false
            }
        }
        floatingactionbutton.setOnClickListener {
            intent = Intent(applicationContext, ChatBotActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setFragment(fr: Fragment) {
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.container, fr)
        frag.commit()
    }
}