package com.example.mobile_cw_02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FootballLeagueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagues(leagues: List<FootballLeague>)

    @Query("SELECT * FROM leagues")
    suspend fun getAllLeagues(): List<FootballLeague>
}