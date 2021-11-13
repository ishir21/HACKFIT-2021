package com.example.hackfit2021.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hackfit2021.Dao.JournalDao
import com.example.hackfit2021.entities.Journals


@Database(entities = [Journals::class], version = 1, exportSchema = false)
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
                ).build()
            }
            return journalsDatabase!!
        }
    }

    abstract fun journalDao():JournalDao
}