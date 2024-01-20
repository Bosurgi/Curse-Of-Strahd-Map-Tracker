package com.example.cosmaptracker.data

class LocationRepository(
    private val locationDao: LocationDao,
    private val distanceDao: DistanceDao
) {

    /***
     * Inserts a location into the database. If the location already exists, ignore the action.
     * @param location The location to insert.
     */
    suspend fun insertLocation(location: Location) {
        locationDao.insertLocation(location)
    }

    /***
     * Updates a location in the database.
     * @param location The location to update.
     */
    suspend fun updateLocation(location: Location) {
        locationDao.updateLocation(location)
    }

    /***
     * Deletes a location from the database.
     * @param location The location to delete.
     */
    suspend fun deleteLocation(location: Location) {
        locationDao.deleteLocation(location)
    }

    /***
     * Gets all locations from the database.
     */
    fun getAllLocations() = locationDao.getAllLocations()

    /***
     * Gets a location from the database.
     * @param name The name of the location to get.
     * @return The location with the given name.
     */
    fun getLocation(name: String) = locationDao.getLocation(name)

    /***
     * Gets the distance between starting point and destination
     * @param startLocationId The id of the starting location.
     * @param destinationLocationId The id of the destination location.
     */
    suspend fun getDistance(startLocationId: Int, destinationLocationId: Int) =
        distanceDao.getDistance(startLocationId, destinationLocationId)

}