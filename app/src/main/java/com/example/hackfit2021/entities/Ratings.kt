package com.example.hackfit2021.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ratings")
data class Rating(
//    @PrimaryKey(autoGenerate = true)
//    var id:Int? = null,
    var rating:Int? = null,
    @PrimaryKey
    var date:String
)