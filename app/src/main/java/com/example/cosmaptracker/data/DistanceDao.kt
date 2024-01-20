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

    /***
     * Gets the distance between two points
     * @param locationId The location to get the distance from.
     * @param destinationId The location to get the distance to.
     */
    @Query("SELECT distance FROM distances WHERE startLocationId = :locationId AND destinationLocationId = :destinationId")
    suspend fun getDistance(locationId: Int, destinationId: Int): Int

}

