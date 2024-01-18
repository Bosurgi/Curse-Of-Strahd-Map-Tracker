package com.example.cosmaptracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Data class for a location.
 * @param id The id of the location.
 * @param name The name of the location.
 */
@Entity(tableName = "locations")
data class Location(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
    // The distance table for this location to other locations.
    val distanceTable: Map<Location, Int> = emptyMap()

}