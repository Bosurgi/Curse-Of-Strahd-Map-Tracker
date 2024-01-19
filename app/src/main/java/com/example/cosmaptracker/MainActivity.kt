package com.example.cosmaptracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.cosmaptracker.data.LocationDatabase
import com.example.cosmaptracker.data.LocationRepository
import com.example.cosmaptracker.ui.screens.HomeViewModel
import com.example.cosmaptracker.ui.screens.Home
import com.example.cosmaptracker.ui.theme.CoSMapTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = HomeViewModel(
            repository = LocationRepository(
                LocationDatabase.getDatabase(this).locationDao()
            )
        )
        setContent {
            Home(viewModel)
        }
    }
}
