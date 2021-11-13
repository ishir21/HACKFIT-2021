package com.example.hackfit2021.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hackfit2021.R
import com.example.hackfit2021.Model.RatingViewModel
import com.example.hackfit2021.Model.RatingViewModelFactory
import com.example.hackfit2021.database.JournalsDatabase
import kotlinx.android.synthetic.main.fragment_ratings.*
import java.text.SimpleDateFormat
import java.util.*


class RatingsFragment : Fragment() {

    private lateinit var viewModel: RatingViewModel

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

        great_card_rating.setOnClickListener {
            viewModel.insert(5,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
        }

        good_card_rating.setOnClickListener {
            viewModel.insert(4,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
        }

        ok_card_rating.setOnClickListener {
            viewModel.insert(3,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
        }

        bad_card_rating.setOnClickListener {
            viewModel.insert(2,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
        }

        terrible_card_rating.setOnClickListener {
            viewModel.insert(1,currentDate)
            Log.d("RatingsFragment", "${viewModel.ratingsList.value}")
        }

//        viewModel.ratingsList.observe(viewLifecycleOwner) { ratings ->
//            Log.d("RatingsFragment", "$ratings")
//        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_ratings, container, false)
    }

}