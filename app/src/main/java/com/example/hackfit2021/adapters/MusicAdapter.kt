package com.example.hackfit2021.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackfit2021.R
import com.example.hackfit2021.entities.Music

class MusicAdapter(private val musicList:ArrayList<Music>):RecyclerView.Adapter<MusicAdapter.MyViewHolder>(){
    private lateinit var mListener : onMusicClickListener
    interface onMusicClickListener{
        fun onMusicClick(position: Int)
    }
    fun setOnMusicClickListener(listener: onMusicClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.music_card_view, parent, false)
        return MyViewHolder(itemView,mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = musicList[position]
        holder.MusicImage.setImageResource(currentItem.musicImage)
        holder.MusicHeading.text = currentItem.musicTitle
        holder.PlayImage.setImageResource(currentItem.playImage)


    }

    override fun getItemCount(): Int {
        return musicList.size
    }



    class MyViewHolder(itemView: View, listener:onMusicClickListener) : RecyclerView.ViewHolder(itemView) {

        val MusicImage: ImageView = itemView.findViewById(R.id.music_logo);
        val MusicHeading: TextView = itemView.findViewById(R.id.music_title);
        val PlayImage: ImageView = itemView.findViewById(R.id.play_logo);

        init{
            itemView.setOnClickListener {
                listener.onMusicClick(adapterPosition)
            }

        }

    }
}