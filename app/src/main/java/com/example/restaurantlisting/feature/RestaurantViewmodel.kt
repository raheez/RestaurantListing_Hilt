package com.example.restaurantlisting.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantlisting.api.RestaurantApi
import com.example.restaurantlisting.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewmodel @Inject constructor(api: RestaurantApi):ViewModel(){

    private val restaurantLiveData = MutableLiveData<List<Restaurant>>()
    val restaurantList :LiveData<List<Restaurant>> = restaurantLiveData

    init {
        viewModelScope.launch {
            val restaurant = api.getRestaurants()
            delay(2000)
            restaurantLiveData.value =restaurant
        }
    }
}