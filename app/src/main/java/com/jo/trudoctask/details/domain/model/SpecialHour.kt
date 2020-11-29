package com.jo.trudoctask.details.domain.model

data class SpecialHour(
    val date: String,
    val end: String,
    val is_closed: Any,
    val is_overnight: Boolean,
    val start: String
)