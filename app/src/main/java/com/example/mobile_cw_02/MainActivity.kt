package com.example.mobile_cw_02

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile_cw_02.ui.theme.MobileCW02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileCW02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Button(onClick = { Intent( applicationContext, AddLeaguesDB::class.java).also { startActivity(it) } }) {
                                Text(text = "Add Leagues to DB")
                            }
                            Button(onClick = { Intent(applicationContext, SearchClubs::class.java).also { startActivity(it) } }) {
                                Text(text = "Search for Clubs By League")
                            }
                            Button(onClick = { Intent(applicationContext, SearchClubsLeague::class.java).also { startActivity(it) } }) {
                                Text(text = "Search for Clubs")
                            }
                        }
                    }
                }
            }
        }
    }
}