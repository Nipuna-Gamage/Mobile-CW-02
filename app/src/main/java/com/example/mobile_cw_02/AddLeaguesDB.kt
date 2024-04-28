package com.example.mobile_cw_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.mobile_cw_02.data.FootballDatabase
import com.example.mobile_cw_02.data.FootballRepository
import androidx.compose.runtime.*
import com.example.mobile_cw_02.data.FootballLeague
import com.example.mobile_cw_02.ui.theme.MobileCW02Theme

class AddLeaguesDB : ComponentActivity() {
    private lateinit var footballRepository: FootballRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Room database and repository
        val database = FootballDatabase.getInstance(this)
        footballRepository = FootballRepository(database)

        setContent {
            MobileCW02Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyApp(footballRepository)
                }
            }
        }
    }

    @Composable
    fun MyApp(footballRepository: FootballRepository) {
        val scope = rememberCoroutineScope()

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    scope.launch {
                        val leagues = getHardcodedLeagues()
                        footballRepository.insertLeagues(leagues)
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Add to DB")
            }
        }
    }
}


fun getHardcodedLeagues(): List<FootballLeague> {
    return listOf(
        FootballLeague("4328", "English Premier League", "Soccer", "Premier League, EPL"),
        FootballLeague("4329", "English League Championship", "Soccer", "Championship"),
        FootballLeague("4330", "Scottish Premier League", "Soccer", "Scottish Premiership, SPFL"),
        FootballLeague("4331", "German Bundesliga", "Soccer", "Bundesliga, Fußball-Bundesliga"),
    )
}
