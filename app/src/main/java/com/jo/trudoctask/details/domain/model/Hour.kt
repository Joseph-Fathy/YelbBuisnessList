package com.jo.trudoctask.details.domain.model

data class Hour(
    val hours_type: String,
    val is_open_now: Boolean,
    val `open`: List<Open>
)