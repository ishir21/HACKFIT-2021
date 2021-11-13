package com.example.hackfit2021


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hackfit2021.fragments.*
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
                    floatingactionbutton.show()
                    floatingactionbutton.setImageDrawable(getDrawable(R.drawable.bot_icon))
                    setFragment(HomeFragment())
                    true
                }

                R.id.tab_diary -> {
                    setFragment(DiaryListFragment())
                    floatingactionbutton.show()
                    floatingactionbutton.setImageDrawable(getDrawable(R.drawable.ic_baseline_add_24))
                    floatingactionbutton.setOnClickListener {
                        replaceFragment(CreateNewJournalFragment.newInstance(),false)
                    }
                    true
                }

                R.id.tab_music_list -> {
                    floatingactionbutton.show()
                    floatingactionbutton.setImageDrawable(getDrawable(R.drawable.bot_icon))
                    setFragment(MusicFragment())
                    true
                }
                R.id.tab_blogs -> {
                    setFragment(BlogsFragment())
                    floatingactionbutton.hide()
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

    fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = this.supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.container,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }

}