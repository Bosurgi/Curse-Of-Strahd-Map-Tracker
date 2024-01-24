package com.example.cosmaptracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cosmaptracker.data.LocationDatabase
import com.example.cosmaptracker.data.LocationRepository
import com.example.cosmaptracker.ui.screens.Home
import com.example.cosmaptracker.ui.screens.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MaterialTheme {
                /* Instantiating ViewModel with a Factory
                 *  This is needed to pass the repository to the HomeViewModel
                 */
                val viewModel =
                    viewModel<HomeViewModel>(factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            // Return the HomeViewModel with the repository
                            return HomeViewModel(
                                repository = LocationRepository(
                                    LocationDatabase.getDatabase(this@MainActivity).locationDao(),
                                    LocationDatabase.getDatabase(this@MainActivity).distanceDao(),
                                )
                            ) as T
                        }
                    })
                Home(viewModel)
            }

        }
    }
}
