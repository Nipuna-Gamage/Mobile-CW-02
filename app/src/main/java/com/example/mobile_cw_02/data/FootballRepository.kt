package com.example.mobile_cw_02.data

import androidx.room.withTransaction

class FootballRepository(private val database: FootballDatabase) {

    suspend fun insertLeagues(leagues: List<FootballLeague>) {
        database.withTransaction {
            database.leagueDao().insertLeagues(leagues)
        }
    }

    suspend fun getAllLeagues(): List<FootballLeague> {
        return database.leagueDao().getAllLeagues()
    }
}