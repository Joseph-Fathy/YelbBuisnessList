package com.jo.trudoctask.list.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jo.trudoctask.R
import com.jo.trudoctask.databinding.BusinessItemBinding
import com.jo.trudoctask.list.domain.model.Business


/**
 * [RecyclerView.Adapter] that can display a [Business].
 */
class BusinessListRecyclerViewAdapter(
    private var values: List<Business>,
    private val itemClickListener: ((Business) -> Unit)?=null
) : RecyclerView.Adapter<BusinessListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.business_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { itemClickListener?.invoke(item) }
    }

    override fun getItemCount(): Int = values.size

    fun setData(data: List<Business>) {
        values = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Business) {
            val binding = DataBindingUtil.bind<BusinessItemBinding>(view)
            binding?.business = item
        }
    }

}