package com.example.cosmaptracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    /***
     * Inserts a location into the database. If the location already exists, ignore the action.
     * @param location The location to insert.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLocation(location: Location)

    /***
     * Updates a location in the database.
     * @param location The location to update.
     */
    @Update
    suspend fun updateLocation(location: Location)

    /***
     * Deletes a location from the database.
     * @param location The location to delete.
     */
    @Delete
    suspend fun deleteLocation(location: Location)

    /***
     * Gets all locations from the database.
     */
    @Query("SELECT * FROM locations ORDER by name ASC")
    fun getAllLocations(): Flow<List<Location>>

    /***
     * Gets a location from the database.
     * @param name The name of the location to get.
     * @return The location with the given name.
     */
    @Query("SELECT * FROM locations WHERE name = :name")
    fun getLocation(name: String): Flow<Location>

    /***
     * Get a location by its id.
     */
    @Query("SELECT * FROM locations WHERE locationId = :locationId")
    fun getLocationById (locationId: Int): Flow<Location>

//    @Query("SELECT * FROM locations WHERE locationId = :locationId")
//    fun getLocationDistances(locationId: Int): Flow<List<LocationWithDistances>>


}