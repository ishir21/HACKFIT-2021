package com.example.hackfit2021.dao

interface RatingDao {
<<<<<<< HEAD

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

=======
>>>>>>> 26ffd8e090403c222f611d13dedcc63df0137eb5
}