package com.example.hackfit2021.Dao

import androidx.room.*
import com.example.hackfit2021.entities.Journals

@Dao
interface JournalDao {
    @Query("SELECT * FROM Journals ORDER BY id DESC")
    suspend fun getAllJournals() : List<Journals>

    @Query("SELECT * FROM Journals WHERE id =:id")
    suspend fun getSpecificJournal(id:Int) : Journals

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJournal(journal:Journals)

    @Delete
    suspend fun deleteJournal(journal:Journals)

    @Query("DELETE FROM Journals WHERE id =:id")
    suspend fun deleteSpecificJournal(id:Int)

    @Update
    suspend fun updateJournal(journal:Journals)
}