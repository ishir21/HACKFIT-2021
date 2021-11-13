package com.example.hackfit2021.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hackfit2021.adapters.JournalsAdapter
import com.example.hackfit2021.R
import com.example.hackfit2021.database.JournalsDatabase
import com.example.hackfit2021.entities.Journals
import kotlinx.android.synthetic.main.fragment_diary_list.*
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList


class DiaryListFragment : BaseFragment() {

    var arrJournals = ArrayList<Journals>()
    var journalsAdapter: JournalsAdapter = JournalsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_diary_list, container, false)

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DiaryListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.setHasFixedSize(true)

        recycler_view.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                val journals = JournalsDatabase.getDatabase(it).journalDao().getAllJournals()
                journalsAdapter.setData(journals)
                arrJournals = journals as ArrayList<Journals>
                recycler_view.adapter = journalsAdapter
            }
        }
        journalsAdapter.setOnClickListener(onClicked)

        search_view.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                val tempArr = ArrayList<Journals>()

                for (arr in arrJournals){
                    if (arr.title!!.lowercase(Locale.getDefault()).contains(p0.toString())){
                        tempArr.add(arr)
                    }
                }

                journalsAdapter.setData(tempArr)
                journalsAdapter.notifyDataSetChanged()
                return true
            }

        })
    }


    private val onClicked = object : JournalsAdapter.OnItemClickListener{
        override fun onClicked(noteId: Int) {


            val fragment :Fragment
            val bundle = Bundle()
            bundle.putInt("journalId",noteId)
            fragment = CreateNewJournalFragment.newInstance()
            fragment.arguments = bundle

            replaceFragment(fragment,false)
        }

    }


    fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.container,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }


}