package com.jo.trudoctask.list.domain.model

import com.google.gson.annotations.SerializedName

/**
 * The response model of the search api
 *
 * @property total Total number of business Yelp finds based on the search criteria.
 * @property businessList List of business Yelp finds based on the search criteria.
 */
data class BusinessApiResponse(
    @SerializedName("total")
    var total: Int = 0,

    @SerializedName("businesses")
    var businessList: List<Business>
)