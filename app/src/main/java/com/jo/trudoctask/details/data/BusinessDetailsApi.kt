package com.jo.trudoctask.details.data

import com.jo.trudoctask.details.domain.model.BusinessDetails
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit API interface
 */
interface BusinessDetailsApi {
    /**
     * This endpoint returns detailed business content
     *
     * @param id The id of the business.
     *
     * @return This endpoint returns up to 1000 businesses based on the provided search criteria
     */
    @GET("businesses/{id}")
    suspend fun getBusinessDetails(
        @Path("id") id: String
    ): BusinessDetails
}