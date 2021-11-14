package com.example.hackfit2021.activities



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.hackfit2021.R
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

                R.id.homeFragment -> {
                    floatingactionbutton.show()
                    floatingactionbutton.setImageDrawable(getDrawable(R.drawable.bot_icon))
                    setFragment(HomeFragment())
                    true
                }

                R.id.diaryListFragment -> {
                    setFragment(DiaryListFragment())
                    floatingactionbutton.show()
                    floatingactionbutton.setImageDrawable(getDrawable(R.drawable.ic_baseline_add_24))
                    floatingactionbutton.setOnClickListener {
                        replaceFragment(CreateNewJournalFragment.newInstance(),false)
                    }
                    true
                }

                R.id.musicFragment -> {
                    setFragment(MusicFragment())
                    true
                }
                R.id.settingsFragment -> {
                    replaceFragment(SettingsFragment(),false)
                    true
                }

                else -> false
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.updateRating -> {
                replaceFragment(RatingsFragment(), false)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    private fun setFragment(fr: Fragment) {
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.container, fr)
        frag.commit()
    }

    private fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = this.supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.container,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }
}