package com.example.mobile_cw_02.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FootballLeague::class], version = 1)
abstract class FootballDatabase : RoomDatabase() {

    abstract fun leagueDao(): FootballLeagueDao

    companion object {
        @Volatile
        private var INSTANCE: FootballDatabase? = null

        fun getInstance(context: Context): FootballDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FootballDatabase::class.java,
                    "football_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}