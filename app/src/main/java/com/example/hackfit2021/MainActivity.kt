package com.example.hackfit2021


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment=HomeFragment()
        val diaryListFragment=DiaryListFragment()
        val musicListFragment=MusicFragment()
        val blogsFragment=BlogsFragment()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.tab_home->setCurrentFragment(homeFragment)
                R.id.tab_diary->setCurrentFragment(diaryListFragment)
                R.id.tab_music_list->setCurrentFragment(musicListFragment)
                R.id.tab_blogs->setCurrentFragment(blogsFragment)
            }
            true
        }    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }
}