package com.example.cosmaptracker.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmaptracker.data.Location
import com.example.cosmaptracker.data.LocationRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: LocationRepository) : ViewModel() {

    private var locations: List<Location> by mutableStateOf(emptyList())
    private var startLocation: Location by mutableStateOf(Location(""))
    private var endLocation: Location by mutableStateOf(Location(""))
    private var distance: Int by mutableIntStateOf(0)

    fun getStartLocation(startLocation: Location) {
        this.startLocation = startLocation
    }

    fun getEndLocation(endLocation: Location) {
        this.endLocation = endLocation
    }

    fun getDistance(distance: Int) {
        this.distance = distance
    }

    fun getAllLocations(): List<Location> {
        viewModelScope.launch {
            repository.getAllLocations().collect {
                it.forEach { location ->
                    locations = locations + location
                }

            }
        }
        return locations
    }

}

