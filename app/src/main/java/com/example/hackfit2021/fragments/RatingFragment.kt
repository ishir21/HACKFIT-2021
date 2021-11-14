package com.example.hackfit2021.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.hackfit2021.R
import com.example.hackfit2021.Model.RatingViewModel
import com.example.hackfit2021.Model.RatingViewModelFactory
import com.example.hackfit2021.activities.TemplateActivity
import com.example.hackfit2021.database.JournalsDatabase
import kotlinx.android.synthetic.main.fragment_ratings.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


class RatingsFragment : Fragment() {

    private lateinit var viewModel: RatingViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this, RatingViewModelFactory(
                JournalsDatabase.getDatabase(
                    requireActivity()
                )
            )
        )[RatingViewModel::class.java]

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date()).toString()


        date_rating.text=currentDate
        great_card_rating.setOnClickListener {
            viewModel.insert(5,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
            // show template then exit
            replaceFragment(HomeFragment(),false)
        }

        good_card_rating.setOnClickListener {
            viewModel.insert(4,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
            replaceFragment(HomeFragment(),false)
        }

        ok_card_rating.setOnClickListener {
            viewModel.insert(3,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
            replaceFragment(HomeFragment(),false)
        }

        bad_card_rating.setOnClickListener {
            viewModel.insert(2,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
            startActivity(Intent(activity, TemplateActivity::class.java))
            replaceFragment(HomeFragment(),false)
        }

        terrible_card_rating.setOnClickListener {
            viewModel.insert(1,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
            startActivity(Intent(activity, TemplateActivity::class.java))
            replaceFragment(HomeFragment(),false)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_ratings, container, false)
    }

//     fun showTemplate{
//
//    }
    private fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.container,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }
}