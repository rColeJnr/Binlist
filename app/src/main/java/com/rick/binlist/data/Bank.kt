package com.rick.binlist.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Bank(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("city")
    val city: String
) : Parcelable