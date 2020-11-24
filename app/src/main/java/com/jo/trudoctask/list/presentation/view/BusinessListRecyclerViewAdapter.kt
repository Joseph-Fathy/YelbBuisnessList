package com.jo.trudoctask.list.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jo.trudoctask.R
import com.jo.trudoctask.list.domain.model.Business


/**
 * [RecyclerView.Adapter] that can display a [Business].
 */
class BusinessListRecyclerViewAdapter(
    private val values: List<Business>
) : RecyclerView.Adapter<BusinessListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.business_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.tvBusinessName.text = item.name
        holder.tvBusinessCategory.text = item.categories.toString()
        holder.rbBusinessesRating.rating = item.rating?.toFloat() ?: 0f
        holder.tvBusinessPrice.text = item.price
        holder.tvBusinessReviewCount.text = item.reviewCount.toString()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivBusinessImage: ImageView = view.findViewById(R.id.ivBusinessImage)
        val tvBusinessName: TextView = view.findViewById(R.id.tvBusinessName)
        val tvBusinessCategory: TextView = view.findViewById(R.id.tvBusinessCategory)
        val rbBusinessesRating: RatingBar = view.findViewById(R.id.rbBusinessesRating)
        val tvBusinessPrice: TextView = view.findViewById(R.id.tvBusinessPrice)
        val tvBusinessReviewCount: TextView = view.findViewById(R.id.tvBusinessReviewCount)
    }
}