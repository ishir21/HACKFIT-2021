package com.example.hackfit2021.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackfit2021.R
import com.example.hackfit2021.adapters.BlogAdapter
import com.example.hackfit2021.entities.Blog

class BlogsActivity : AppCompatActivity() {
    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList: ArrayList<Blog>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var blogdata: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blogs)
//        var blogAdapter = BlogAdapter(newArrayList,this)
        //    private var layoutManager: RecyclerView.LayoutManager? = null
//    private var adapter: RecyclerView.Adapter<BlogAdapter.ViewHolder>? = null
//    private lateinit var newRecyclerview:RecyclerView

//        override fun onCreateView(
//
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//
//        ): View? {
//            // Inflate the layout for this fragment
//            return inflater.inflate(R.layout.fragment_blogs, container, false)
//        }


        imageId = arrayOf(
            R.drawable.blog_1_img,
            R.drawable.blog_2_img,
            R.drawable.blog_3_img,
            R.drawable.blog_4_img,
            R.drawable.blog_5_img,
            R.drawable.blog_6_img,
            R.drawable.blog_7_img,
            R.drawable.blog_8_img,
            R.drawable.blog_9_img

        )
        heading = arrayOf(
            "Talking It Out: Talk Therapy and How It Can Benefit You",
            "What Is Person (Client) Centered Therapy?",
            "Relationship Anxiety: Signs, Causes, and Tips to Overcome it",
            "5 Mental Health Tips for Surviving the School Year",
            "Why You Should Stick with Therapy, Even When It’s Tough",
            "Ayurveda: “A Way Of Healing Mental Health Issues” ",
            "Child’s Mental Health Care During Pandemic",
            "Acupressure & Naturopathy: “A Way Of Healing Mental Health”",
            "People with Bipolar Deserve Love",
        )
        blogdata = arrayOf(getString(R.string.blog_1),
            getString(R.string.blog_2),
            getString(R.string.blog_3),
            getString(R.string.blog_4),
            getString(R.string.blog_5),
            getString(R.string.blog_6),
            getString(R.string.blog_7),
            getString(R.string.blog_8),
            getString(R.string.blog_9)
        )
//        blogRecycler.apply {
//            // set a LinearLayoutManager to handle Android
//            // RecyclerView behavior
//            layoutManager = LinearLayoutManager(activity)
//            // set the custom adapter to the RecyclerView
////            adapter = BlogAdapter()
//            blogRecycler.setHasFixedSize(true)
//            newArrayList = arrayListOf<Blogs>()
//            getUserData()
//
//        }

        newRecyclerview = findViewById(R.id.blogRecycler)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)
        newArrayList = arrayListOf<Blog>()
        getUserData()


    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val blogs = Blog(imageId[i], heading[i])
            newArrayList.add(blogs)
        }
        var adapter= BlogAdapter(newArrayList)
        newRecyclerview.adapter= adapter
        adapter.setOnItemClickListener(object : BlogAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@BlogsActivity,"You clicked on $position",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@BlogsActivity,BlogDataActivity::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageid",newArrayList[position].titleImage)
                intent.putExtra("blogmain",blogdata[position])
                startActivity(intent)
            }

        })



    }



}
