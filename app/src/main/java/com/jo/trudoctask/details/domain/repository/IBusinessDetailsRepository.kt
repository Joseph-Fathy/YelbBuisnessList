package com.jo.trudoctask.details.domain.repository

import com.jo.trudoctask.details.domain.result.BusinessDetailsResult

interface IBusinessDetailsRepository {
    suspend fun getBusinessDetails(id: String): BusinessDetailsResult
}