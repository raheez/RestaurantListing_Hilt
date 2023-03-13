package com.example.restaurantlisting.feature

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurantlisting.data.Restaurant
import com.example.restaurantlisting.databinding.RestaurantItemListBinding

class Adapter(
    list:ArrayList<Restaurant>,
    context :Context
) :
    ListAdapter<Restaurant, Adapter.RestaurantViewHolder>(RestaurantComparator()){

    val mList = list
    val mContext = context

    class RestaurantViewHolder(val binding: RestaurantItemListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val mView = RestaurantItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestaurantViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mList.size;
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {

        mList.get(position).let {
            holder.binding.textviewName.text = it.name
            holder.binding.textviewType.text = it.type
            holder.binding.textviewAddress.text = it.address
            Glide.with(mContext).load(it.logo).into(holder.binding.imageViewLogo)
            holder.binding.textviewName

        }
    }

    class RestaurantComparator :DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem == newItem

    }
}