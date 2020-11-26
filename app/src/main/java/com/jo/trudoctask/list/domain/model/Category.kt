package com.jo.trudoctask.list.domain.model

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Category in a title and alias pair associated with a business.
 *
 * @property alias Alias of a category, when searching for business in certain categories, use alias rather than the title.
 * @property title Title of a category for display purpose.
 */
@Parcelize
data class Category(
    @SerializedName("alias")
    @Expose
    var alias: String? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null
) : Parcelable