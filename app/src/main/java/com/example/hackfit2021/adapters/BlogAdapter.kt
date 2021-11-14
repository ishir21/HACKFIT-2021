package com.example.hackfit2021.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackfit2021.R
<<<<<<< HEAD
import com.example.hackfit2021.entities.Blog
=======
import com.example.hackfit2021.data.Blog
>>>>>>> 26ffd8e090403c222f611d13dedcc63df0137eb5

import kotlinx.android.synthetic.main.blog_card_view.view.*

class BlogAdapter(private val bloglist:ArrayList<Blog>): RecyclerView.Adapter<BlogAdapter.MyViewHolder>() {
<<<<<<< HEAD
    //    private var titles = arrayOf("Blog 1","Blog 2","Blog 3","Blog 4","Blog 5")
=======
//    private var titles = arrayOf("Blog 1","Blog 2","Blog 3","Blog 4","Blog 5")
>>>>>>> 26ffd8e090403c222f611d13dedcc63df0137eb5
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.blog_card_view, parent, false)
        return MyViewHolder(itemView,mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = bloglist[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading


    }

    override fun getItemCount(): Int {
        return bloglist.size
    }



    class MyViewHolder(itemView: View,listener:onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val titleImage: ImageView = itemView.findViewById(R.id.item_image);
        val tvHeading: TextView = itemView.findViewById(R.id.item_title);
        init{
            itemView.setOnClickListener {
<<<<<<< HEAD
                listener.onItemClick(absoluteAdapterPosition)
            }

        }

    }


}
=======
                listener.onItemClick(adapterPosition)
            }

        }

        }


}
>>>>>>> 26ffd8e090403c222f611d13dedcc63df0137eb5
