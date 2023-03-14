package com.example.restaurantlisting.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantlisting.R
import com.example.restaurantlisting.data.Restaurant
import com.example.restaurantlisting.databinding.ActivityMainBinding
import com.example.restaurantlisting.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewmodel: RestaurantViewmodel by viewModels()
    lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding.apply {

            mBinding.progressBar.visibility = View.VISIBLE
            viewmodel.restaurants.observe(this@MainActivity, Observer {

                    result ->

                println("size_is"+result.data?.size)
                result.data?.let {
                    val adapter = Adapter(result.data as ArrayList<Restaurant>, this@MainActivity)
                    this.idRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    this.idRecyclerView.adapter = adapter

                }

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textviewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()

            })
        }
    }
}
