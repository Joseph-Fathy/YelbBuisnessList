package com.jo.trudoctask.list.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Data class of the business items in the list
 *
 * @property id Unique Yelp ID of this business. Example: '4kMBvIEWPxWkWKFN__8SxQ'
 * @property name Name of this business.
 * @property alias Unique Yelp alias of this business. Can contain unicode characters. Example: 'yelp-san-francisco'.
 * @property imageUrl URL of photo for this business.
 * @property rating Rating for this business (value ranges from 1, 1.5, ... 4.5, 5).
 * @property phone Phone number of the business.
 * @property categories List of category title and alias pairs associated with this business.
 * @property reviewCount Number of reviews for this business.
 * @property location Location of this business, including address, city, state, zip code and country.
 */
data class Business(

    @SerializedName("id")
    @Expose
    var id: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("alias")
    @Expose
    var alias: String? = null,

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null,

    @SerializedName("price")
    @Expose
    var price: String? = null,

    @SerializedName("rating")
    @Expose
    var rating: Float = 0f,

    @SerializedName("phone")
    @Expose
    var phone: String? = null,

    @SerializedName("categories")
    @Expose
    var categories: List<Category?>? = null,

    @SerializedName("review_count")
    @Expose
    var reviewCount: Int? = null,

    @SerializedName("location")
    @Expose
    var location: Location? = null,
) {
    fun getCategoriesString(): String {
        return if (categories.isNullOrEmpty()) "" else {
            val categoriesNames: List<String> =
                categories!!.map {
                    it?.alias ?: ""
                }
            categoriesNames.joinToString()
        }
    }
}