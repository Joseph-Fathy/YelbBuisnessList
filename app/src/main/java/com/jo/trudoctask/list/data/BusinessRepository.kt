package com.jo.trudoctask.list.data

import com.jo.trudoctask.list.domain.repository.IBusinessRepository
import com.jo.trudoctask.list.domain.result.BusinessesListResult
import javax.inject.Inject

/**
 * Implementation of the [IBusinessRepository] that's responsible for getting the list of businesses
 * from the backend using the instance of [BusinessApi]
 *
 * @property api the instance of [BusinessApi] used to call the backend to get the list of businesses
 */
class BusinessRepository @Inject constructor(private val api: BusinessApi) : IBusinessRepository {
    override suspend fun getBusinessList(
        location: String,
        keyword: String?,
        limit: Int,
        offset: Int
    ): BusinessesListResult {
        return try {
            val businessesList = api.getBusinessList(location, keyword, limit, offset).businessList
            when {
                businessesList.isNullOrEmpty() -> BusinessesListResult.Empty
                else -> BusinessesListResult.Data(businessesList)
            }
        } catch (e: Exception) {
            BusinessesListResult.Error(e)
        }
    }
}