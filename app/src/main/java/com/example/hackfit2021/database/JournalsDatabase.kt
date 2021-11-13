package com.example.hackfit2021.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hackfit2021.Dao.JournalDao
import com.example.hackfit2021.Dao.RatingDao
import com.example.hackfit2021.entities.Journals
import com.example.hackfit2021.entities.Rating


@Database(entities = [Journals::class, Rating::class], version = 2, exportSchema = false)
abstract class JournalsDatabase : RoomDatabase() {

    companion object {
        var journalsDatabase: JournalsDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): JournalsDatabase {
            if (journalsDatabase == null) {
                journalsDatabase = Room.databaseBuilder(
                    context
                    , JournalsDatabase::class.java
                    , "journals.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return journalsDatabase!!
        }
    }

    abstract fun journalDao():JournalDao
    abstract fun ratingsDao() : RatingDao

}