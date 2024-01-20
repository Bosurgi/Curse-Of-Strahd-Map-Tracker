package com.example.cosmaptracker.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "distances",
//    foreignKeys = [
//        ForeignKey(
//            entity = Location::class,
//            parentColumns = ["locationId"],
//            childColumns = ["startLocationId"]
//        ),
//    ]
)
data class Distance(
    @PrimaryKey(autoGenerate = true) val distanceId: Int = 0,
    val startLocationId: Int, // Foreign key to the location table.
    val destinationLocationId: Int, // Foreign key to the location table.
    val distance: Int,
)

//data class LocationWithDistances(
//    @Embedded val location: Location,
//    @Relation(
//        parentColumn = "name",
//        entityColumn = "distance",
//        entity = Distance::class
//    )
//    val distances: List<Distance>
//)