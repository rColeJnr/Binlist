package com.rick.binlist.data

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@TypeConverters
class Converters {

    @TypeConverter
    fun fromNumber(number: Number): String =
        Gson().toJson(
            number,
            object : TypeToken<Number>() {}.type
        ) ?: "[]"

    @TypeConverter
    fun toNumber(number: String): Number =
        Gson().fromJson<Number>(
            number,
            object : TypeToken<Number>() {}.type
        )!!

    @TypeConverter
    fun fromCountry(country: Country): String =
        Gson().toJson(
            country,
            object : TypeToken<Country>() {}.type
        ) ?: "[]"

    @TypeConverter
    fun toCountry(country: String): Country =
        Gson().fromJson<Country>(
            country,
            object : TypeToken<Country>() {}.type
        )!!
}