package com.jo.trudoctask.list.presentation.view_state

import com.jo.trudoctask.list.domain.model.Business

/**
 * ViewState is model used to render the state of view
 * according to the [Result]
 *
 * @property isLoading Show loading progress bar.
 * @property isEmpty Show loading empty view.
 * @property data Show the data.
 * @property error Show the error view.
 */
data class BusinessListViewState(
    var isLoading: Boolean = false,
    var isEmpty: Boolean = false,
    var data: List<Business>? = emptyList(),
    var error: Throwable? = null
)
