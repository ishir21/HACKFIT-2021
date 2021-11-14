package com.example.hackfit2021.fragments

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackfit2021.database.JournalsDatabase
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.text.SimpleDateFormat
import java.util.*
import com.applandeo.materialcalendarview.EventDay
import com.example.hackfit2021.Model.RatingViewModel
import com.example.hackfit2021.Model.RatingViewModelFactory
import com.example.hackfit2021.R
import kotlinx.android.synthetic.main.fragment_ratings.*
import kotlin.math.log


class CalendarFragment : Fragment() {

    private lateinit var viewModel: RatingViewModel
    private var icon : Int = R.drawable.ic_delete
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this, RatingViewModelFactory(
                JournalsDatabase.getDatabase(
                    requireActivity()
                )
            )
        )[RatingViewModel::class.java]
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date()).toString()

        viewModel.getRating(currentDate)
        viewModel.ratings.observe(viewLifecycleOwner)
        {
            Log.d("RATING", it.rating.toString())
            when (it.rating) {
                1 -> {
                    icon = R.drawable.star
                    val calendar = Calendar.getInstance()
                    calendarView.setDate(calendar)

                    val events: MutableList<EventDay> = ArrayList()
                    calendar.add(Calendar.DAY_OF_MONTH, 0)
                    events.add(EventDay(calendar, icon))
                    calendarView.setEvents(events)
                    println(icon)

                }
                2 -> {
                    icon = R.drawable.smile
                }
                3 -> {
                    icon = R.drawable.confused
                }
                4-> {
                    icon = R.drawable.sad
                }
                5 -> {
                    icon = R.drawable.crying
                }
            }
        }


//        println(Rating)
//        viewModel.rating.observe(viewLifecycleOwner) {
//            Log.d("Calendar fragment", it.rating.toString())
//        }

//        calendar.add(Calendar.DAY_OF_MONTH,-1)
//        events.add(EventDay(calendar, icon))


    }
}