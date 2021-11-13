package com.example.hackfit2021.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hackfit2021.R
import kotlinx.android.synthetic.main.fragment_home.*
import ru.cleverpumpkin.calendar.CalendarDate
import ru.cleverpumpkin.calendar.CalendarView
import java.util.*

class CalendarFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarView = view.findViewById(R.id.calendar_view) as CalendarView
        val calendar = Calendar.getInstance()

// Initial date
        calendar.set(2021, Calendar.NOVEMBER, 1)
        val initialDate = CalendarDate(calendar.time)

// Minimum available date
        calendar.set(2021, Calendar.NOVEMBER, 15)
        val minDate = CalendarDate(calendar.time)

// Maximum available date
        calendar.set(2198, Calendar.NOVEMBER, 15)
        val maxDate = CalendarDate(calendar.time)

// List of preselected dates that will be initially selected
//        val preselectedDates: List<CalendarDate> = getPreselectedDates()

// The first day of week
        val firstDayOfWeek = java.util.Calendar.MONDAY

// Set up calendar with all available parameters
        calendarView.setupCalendar(
            initialDate = initialDate,
            minDate = minDate,
            maxDate = maxDate,
            selectionMode = CalendarView.SelectionMode.NONE,
            firstDayOfWeek = firstDayOfWeek,
            showYearSelectionView = true
        )

        }
    }