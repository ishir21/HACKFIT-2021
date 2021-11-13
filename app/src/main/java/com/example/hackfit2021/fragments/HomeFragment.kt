package com.example.hackfit2021.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import com.example.hackfit2021.ChatBotActivity
import com.example.hackfit2021.R
import com.example.hackfit2021.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import ru.cleverpumpkin.calendar.CalendarView


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val cardView = view?.findViewById(R.id.layout) as LinearLayout


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Initialize
        home_check_in_card.setOnClickListener {
            replaceFragment(CalendarFragment(), false)
        }
    }
    private fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.container,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }
}