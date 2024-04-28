package com.example.mobile_cw_02.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leagues")
data class FootballLeague(
    @PrimaryKey val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String
)
