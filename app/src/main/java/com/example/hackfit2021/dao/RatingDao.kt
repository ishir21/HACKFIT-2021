package com.example.hackfit2021.Dao

import androidx.room.*
import com.example.hackfit2021.entities.Rating

@Dao
interface RatingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRating(rating: Rating)

    @Update
    suspend fun updateRating(rating: Rating)

    @Delete
    suspend fun deleteRating(rating: Rating)

    @Query("SELECT * FROM Ratings ORDER BY date DESC")
    suspend fun getAllRatings() : List<Rating>

    @Query("SELECT * FROM Ratings WHERE date = :date")
    suspend fun getRating(date: String) : Rating

}