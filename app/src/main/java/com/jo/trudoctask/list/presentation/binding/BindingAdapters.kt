package com.jo.trudoctask.list.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jo.trudoctask.list.presentation.view.BusinessListRecyclerViewAdapter
import com.jo.trudoctask.list.presentation.view_state.BusinessListViewState

/**
 * Set the adapter of the recycler view with the list from the viewState.
 *
 * @param viewState The container of the list of businesses
 */
@BindingAdapter("viewState")
fun RecyclerView.setBusinessListViewState(viewState: BusinessListViewState?) {
    if (viewState?.data?.isNotEmpty() == true) {
        if (adapter is BusinessListRecyclerViewAdapter)
            (adapter as BusinessListRecyclerViewAdapter).setData(viewState.data!!)
    }
}

/**
 * Fill ImageView with a photo using [Glide]
 *
 * @param imageUrl the url of the image to load
 */
@BindingAdapter("imageUrl")
fun ImageView.loadImageFromUrl(
    imageUrl: String?,
) {
    if (imageUrl != null && imageUrl.isNotBlank()) {
        val glide = Glide
            .with(this)
            .load(imageUrl)
            .thumbnail(0.2f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
        glide.into(this)
    }


}