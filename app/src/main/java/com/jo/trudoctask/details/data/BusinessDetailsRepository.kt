package com.jo.trudoctask.details.data

import com.jo.trudoctask.details.domain.repository.IBusinessDetailsRepository
import com.jo.trudoctask.details.domain.result.BusinessDetailsResult
import javax.inject.Inject

class BusinessDetailsRepository @Inject constructor(private val api: BusinessDetailsApi) :
    IBusinessDetailsRepository {
    override suspend fun getBusinessDetails(id: String): BusinessDetailsResult {
        return try {
            val businessDetails = api.getBusinessDetails(id)
            if (businessDetails.id != null)
                BusinessDetailsResult.Data(businessDetails)
            else
                BusinessDetailsResult.Empty
        } catch (e: Exception) {
            BusinessDetailsResult.Error(e)
        }
    }
}