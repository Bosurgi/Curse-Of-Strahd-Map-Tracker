package com.example.cosmaptracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Location::class, Distance::class], version = 1, exportSchema = false)
abstract class LocationDatabase : RoomDatabase() {

    /***
     * Gets the location DAO.
     */
    abstract fun locationDao(): LocationDao
    abstract fun distanceDao(): DistanceDao

    companion object {
        /***
         * Keeps a reference of the Database maintaining only one instance of the DB.
         */
        @Volatile
        private var Instance: LocationDatabase? = null

        /***
         * Gets the database instance.
         * @param context The context.
         * @return The database instance.
         */
        fun getDatabase(context: Context): LocationDatabase {
            // If the Instance is not null, return it, otherwise it creates the DB.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, LocationDatabase::class.java, "location_database")
                    // If the schema changes we can add migration logic here.
                    .fallbackToDestructiveMigration()
                    // Create the database from the asset file.
                    .createFromAsset("database/location_database.db")
                    // Building the database
                    .build()
                    // Keep the reference to the created DB.
                    .also { Instance = it }
            } // End of Synchronised
        }

    } // End of Companion Object
} // End of Class