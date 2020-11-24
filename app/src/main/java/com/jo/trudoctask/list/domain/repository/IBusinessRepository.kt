package com.jo.trudoctask.list.domain.repository

import com.jo.trudoctask.list.domain.result.BusinessesListResult

/**
 * Repository to get the businesses list.
 */
interface IBusinessRepository {
    /**
     * Get the business list that match the search criteria
     *
     * @param location This string indicates the geographic area to be used when searching for businesses.
     * @param keyword Search term, for example "food" or "restaurants".
     * @param limit  Number of business results to return.
     * @param offset Offset the list of returned business results by this amount.
     *
     * @return Instance of [BusinessesListResult] wrapping the list.
     */
    suspend fun getBusinessList(
        location: String,
        keyword: String?,
        limit: Int,
        offset: Int
    ): BusinessesListResult
}