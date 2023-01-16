package com.rick.binlist.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "bin_db")
data class Bin(
    @PrimaryKey (autoGenerate = false)
    @SerializedName("id")
    val id: Long,
    @SerializedName("number")
    val number: Number,
    @SerializedName("scheme")
    val scheme: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("prepaid")
    val prepaid: Boolean,
    @SerializedName("country")
    val country: Country,
    @SerializedName("bank")
    val bank: Bank
) : Parcelable