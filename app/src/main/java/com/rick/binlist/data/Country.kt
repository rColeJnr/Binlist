package com.rick.binlist.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Country(
    @SerializedName("numeric")
    val numeric: String,
    @SerializedName("alpha2")
    val alpha2: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("emoji")
    val emoji: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("latitude")
    val latitude: Int,
    @SerializedName("longitude")
    val longitude: Int
) : Parcelable