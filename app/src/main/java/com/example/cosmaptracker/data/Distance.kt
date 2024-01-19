package com.example.cosmaptracker.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "distances")
data class Distance(
    @PrimaryKey(autoGenerate = true) val distanceId: Int = 0,
    val locationId: Int, // Foreign key to the location table.
    val targetLocationId: Int, // Foreign key to the location table.
    val distance: Int,
) {

}

@Entity(primaryKeys = ["locationId", "targetLocationId"])
data class LocationDistanceCrossRef(
    val locationId: Int,
    val targetLocationId: Int
)

data class LocationWithDistances(
    @Embedded val location: Location,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "distanceId",
        entity = Distance::class,
        associateBy = Junction(LocationDistanceCrossRef::class)
    )
    val distances: List<Distance>
)
