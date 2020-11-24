package com.jo.trudoctask.list.domain.result

import com.jo.trudoctask.list.domain.model.Business

/**
 * Unify results of the businesses list request.
 *
 * Loading: Show/hide loading,
 * Empty: No Data,
 * Error: Show the error,
 * Data: List of the businesses.
 **/
sealed class BusinessesListResult {
    object Loading : BusinessesListResult()
    object Empty : BusinessesListResult()
    class Error(val error: Throwable) : BusinessesListResult()
    class Data(val data: List<Business>) : BusinessesListResult()
}

