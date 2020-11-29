package com.jo.trudoctask.details.domain.model

data class BusinessDetails(
    var alias: String? = null,
    var categories: List<Category>? = null,
    var coordinates: Coordinates? = null,
    var display_phone: String? = null,
    var hours: List<Hour>? = null,
    var id: String? = null,
    var image_url: String? = null,
    var is_claimed: Boolean? = null,
    var is_closed: Boolean? = null,
    var location: Location? = null,
    var name: String? = null,
    var phone: String? = null,
    var photos: List<String>? = null,
    var price: String? = null,
    var rating: Float? = null,
    var review_count: Int? = null,
    var special_hours: List<SpecialHour>? = null,
    var transactions: List<Any>? = null,
    var url: String? = null
) {
    override fun toString(): String {
        return "alias = $alias \nname = $name \nphone = $phone"
    }
}