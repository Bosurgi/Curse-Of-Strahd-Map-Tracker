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
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
) {
    constructor(name: String) : this(0, name)
}