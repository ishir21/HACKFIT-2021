package com.example.hackfit2021.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.hackfit2021.R

class BlogDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_data)
        val headingblog: TextView = findViewById(R.id.heading)
        val mainblog: TextView = findViewById(R.id.blogmain)
        val image: ImageView = findViewById(R.id.blogimg)

        val bundle: Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val imageid = bundle.getInt("imageid")
        val blogmain = bundle.getString("blogmain")

        headingblog.text = heading
        mainblog.text = blogmain
        image.setImageResource(imageid)
    }
}