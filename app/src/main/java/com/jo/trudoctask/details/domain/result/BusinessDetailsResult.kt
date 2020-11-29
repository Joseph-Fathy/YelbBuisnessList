package com.jo.trudoctask.details.domain.result

import com.jo.trudoctask.details.domain.model.BusinessDetails

sealed class BusinessDetailsResult {
    object Loading : BusinessDetailsResult()
    object Empty : BusinessDetailsResult()
    class Error(val error: Throwable) : BusinessDetailsResult()
    class Data(val data: BusinessDetails) : BusinessDetailsResult()
}