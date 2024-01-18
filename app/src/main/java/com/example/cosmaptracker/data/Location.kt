package com.example.cosmaptracker.data

data class Location(val name: String) {

    var distanceTable: Map<Location, Int> = emptyMap()

}