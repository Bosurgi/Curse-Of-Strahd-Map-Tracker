package com.example.cosmaptracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DistanceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDistance(destination: Distance)

    /***
     * Updates a Distance in the database.
     * @param distance The Distance to update.
     */
    @Update
    suspend fun updateDistance(distance: Distance)

    /***
     * Deletes a distance from the database.
     * @param distance The location to delete.
     */
    @Delete
    suspend fun deleteDistance(distance: Distance)

    @Query("SELECT * FROM distances WHERE locationId = :startLocationId AND targetLocationId = :endLocationId")
    suspend fun getDistance(startLocationId: Int, endLocationId: Int) : Distance?

    // Example
    // SELECT distance from distances where locationId in (select locationId from locations where name = "Barovia")
}

