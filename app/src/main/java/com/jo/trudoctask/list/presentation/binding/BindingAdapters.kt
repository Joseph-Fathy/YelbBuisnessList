package com.jo.trudoctask.list.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jo.trudoctask.list.presentation.view.BusinessListRecyclerViewAdapter
import com.jo.trudoctask.list.presentation.view_state.BusinessListViewState

@BindingAdapter("viewState")
fun RecyclerView.setBusinessListViewState(viewState: BusinessListViewState?) {
    if (viewState?.data?.isNotEmpty() == true) {
        adapter = BusinessListRecyclerViewAdapter(viewState.data!!)
    }
}