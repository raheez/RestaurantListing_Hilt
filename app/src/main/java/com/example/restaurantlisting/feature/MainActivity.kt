package com.example.restaurantlisting.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantlisting.R
import com.example.restaurantlisting.data.Restaurant
import com.example.restaurantlisting.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewmodel :RestaurantViewmodel by viewModels()
    lateinit var  mBinding :ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding.apply {

            mBinding.progressBar.visibility = View.VISIBLE
            viewmodel?.restaurantList?.observe(this@MainActivity, Observer {

                println("size_is"+it.size)
                val adapter = Adapter(it as ArrayList<Restaurant>,this@MainActivity)
                this.idRecyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
                this.idRecyclerView.adapter = adapter
                if (it.isNotEmpty()){
                    mBinding.progressBar.visibility = View.GONE
                }
            })
        }
    }
}
