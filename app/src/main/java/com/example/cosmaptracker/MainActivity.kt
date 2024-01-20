package com.example.cosmaptracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cosmaptracker.data.LocationDatabase
import com.example.cosmaptracker.data.LocationRepository
import com.example.cosmaptracker.ui.screens.HomeViewModel
import com.example.cosmaptracker.ui.screens.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = HomeViewModel(
            repository = LocationRepository(
                LocationDatabase.getDatabase(this).locationDao(),
                LocationDatabase.getDatabase(this).distanceDao(),
            )
        )
        setContent {
            Home(viewModel)
        }
    }
}
