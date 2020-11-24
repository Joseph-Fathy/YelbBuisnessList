package com.jo.trudoctask.list.domain.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

/**
 * Location of a business, including address, city, state, zip code and country.
 *
 * @property city City of this business.
 * @property country ISO 3166-1 alpha-2 country code of this business.
 * @property address1 Street address of this business.
 * @property address2 Street address of this business, continued.
 * @property address3 Street address of this business, continued.
 * @property state ISO 3166-2 (with a few exceptions) state code of this business.
 * @property zipCode Zip code of this business.
 */
data class Location(
    @SerializedName("city")
    @Expose
    var city: String? = null,

    @SerializedName("country")
    @Expose
    var country: String? = null,

    @SerializedName("address1")
    @Expose
    var address1: String? = null,

    @SerializedName("address2")
    @Expose
    var address2: String? = null,

    @SerializedName("address3")
    @Expose
    var address3: String? = null,

    @SerializedName("state")
    @Expose
    var state: String? = null,

    @SerializedName("zip_code")
    @Expose
    var zipCode: String? = null
)