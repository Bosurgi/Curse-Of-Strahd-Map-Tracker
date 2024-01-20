package com.example.cosmaptracker.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmaptracker.data.Location
import com.example.cosmaptracker.data.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: LocationRepository) : ViewModel() {

    private var locations = mutableStateListOf<Location>()
    // TODO: This might cause a bug -> Need to check how to fetch location from Database
    var startLocation: Location by mutableStateOf(Location(""))
    var endLocation: Location by mutableStateOf(Location(""))

    //private var distance: Int by mutableIntStateOf(0)
    // For now speed is set to 3 Miles/h
    // TODO: Replace this with a slider to select the speed
    private val SPEED = 3

    var calculatedDistanceFlow = MutableStateFlow<Int?>(null)

    init {
        viewModelScope.launch {
            repository.getAllLocations().collect{
                it.forEach{ location ->
                    locations.add(location)
                }
            }
        }
    }

    @JvmName("GetStartLocation")
    fun getStartLocation(): Location {
        return startLocation
    }

    @JvmName("GetEndLocation")
    fun getEndLocation(): Location {
        return endLocation
    }

    /***
     * It gets the distance to the target location.
     * Each Hex is 4 Miles.
     */
    suspend fun getDistance(startLocation: Location, endLocation: Location) {
        val distance = repository.getDistance(startLocation.locationId, endLocation.locationId)
        calculatedDistanceFlow.value = distance / 4

    }
//    suspend fun calculateDistance(startLocation: Location, endLocation: Location) {
//
//        val distance = getDistance(startLocation, endLocation)
//        calculatedDistanceFlow.value = distance
//    }

    /***
     * It gets the time to the target location.
     * Each Hex is 4 Miles.
     * TODO: Replace this with times expressed in Minutes/Hours accordingly.
     * @return The time in hours.
     */
    @JvmName("getTime")
    fun getTime(): Int {
        return calculatedDistanceFlow.value?.div(SPEED) ?: 0
    }

    /***
     * Gets all locations from the database.
     * @return locations The list of locations.
     */
    @JvmName("getAllLocations")
    fun getAllLocations(): List<Location> {
        viewModelScope.launch {
            locations.clear()
            repository.getAllLocations().collect { locations.addAll(it) }
        }
        return locations
    }

}

