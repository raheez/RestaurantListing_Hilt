package com.example.restaurantlisting.data

import androidx.room.Entity


@Entity(tableName = "restaurants")
data class Restaurant(
    val name: String,
    val type: String,
    val logo: String,
    val address: String
) {
}