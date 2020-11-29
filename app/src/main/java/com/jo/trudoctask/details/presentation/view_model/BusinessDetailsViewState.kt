package com.jo.trudoctask.details.presentation.view_model

import com.jo.trudoctask.details.domain.model.BusinessDetails

data class BusinessDetailsViewState(
    var loading: Boolean = false,
    var empty: Boolean = false,
    var error: Throwable? = null,
    var data: BusinessDetails? = null
)