package com.jo.trudoctask.list.data

import com.jo.trudoctask.list.domain.model.BusinessApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API interface
 */
interface BusinessApi {
    /**
     * Search for businesses and get the businesses list that match the search criteria
     *
     * @param location Required if either latitude or longitude is not provided.
     * This string indicates the geographic area to be used when searching for businesses.
     * Examples: "New York City", "NYC", "350 5th Ave, New York, NY 10118".
     * Businesses returned in the response may not be strictly within the specified location.
     *
     * @param keyword Search term, for example "food" or "restaurants".
     * The term may also be business names, such as "Starbucks".
     * If term is not included the endpoint will default to searching across businesses from a small number of popular categories.
     *
     * @param limit Number of business results to return. By default, it will return 20. Maximum is 50.
     *
     * @param offset Offset the list of returned business results by this amount.
     *
     * @return This endpoint returns up to 1000 businesses based on the provided search criteria
     */
    @GET("businesses/search")
    suspend fun getBusinessList(
        @Query("location") location: String,
        @Query("term") keyword: String?,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): BusinessApiResponse
}