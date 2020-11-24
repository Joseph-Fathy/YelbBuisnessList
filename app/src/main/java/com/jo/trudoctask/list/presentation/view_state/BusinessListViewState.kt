package com.jo.trudoctask.list.presentation.view_state

import com.jo.trudoctask.list.domain.model.Business

data class BusinessListViewState(
    var isLoading: Boolean = false,
    var isEmpty: Boolean = false,
    var data: List<Business>? = emptyList(),
    var error: Throwable? = null
)
