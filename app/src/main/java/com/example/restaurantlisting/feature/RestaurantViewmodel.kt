package com.example.restaurantlisting.feature

import androidx.lifecycle.*
import com.example.restaurantlisting.api.RestaurantApi
import com.example.restaurantlisting.data.Restaurant
import com.example.restaurantlisting.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewmodel @Inject constructor(repository: RestaurantRepository):ViewModel(){

//    private val restaurantLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurantList :LiveData<List<Restaurant>> = restaurantLiveData
//
//    init {
//        viewModelScope.launch {
//            val restaurant = api.getRestaurants()
//            //delay(1000)
//            restaurantLiveData.value =restaurant
//        }
//    }

    val restaurants = repository.getRestaurants().asLiveData()
}