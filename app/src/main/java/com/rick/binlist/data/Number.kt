package com.rick.binlist.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Number(
    @SerializedName("length")
    val length: Int,
    @SerializedName("luhn")
    val luhn: Boolean
) : Parcelable