package com.example.restaurantlisting.api

import com.example.restaurantlisting.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {

    companion object{
        const val base_url = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants():List<Restaurant>
}
