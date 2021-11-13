package com.example.hackfit2021.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackfit2021.R
import com.example.hackfit2021.activities.MainActivity
import com.example.hackfit2021.adapters.BlogAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_blogs.*

class BlogsFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<BlogAdapter.MyViewHolder>? = null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blogs, container, false)
    }

//    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(itemView, savedInstanceState)
//        blogRecycler.apply {
//            // set a LinearLayoutManager to handle Android
//            // RecyclerView behavior
//            layoutManager = LinearLayoutManager(activity)
//            // set the custom adapter to the RecyclerView
//            adapter = BlogAdapter()
//        }
//    }
//    override fun onResume() {
//        super.onResume()
//        val mainActivity = activity as MainActivity?
//        mainActivity?.floatingactionbutton?.hide()
//        }
    }