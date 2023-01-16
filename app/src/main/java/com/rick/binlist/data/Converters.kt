package com.rick.binlist.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromNumber(number: Number): String =
        jsonParser.toJson<Number>(
            number,
            object : TypeToken<Number>() {}.type
        ) ?: "[]"

    @TypeConverter
    fun toNumber(number: String): Number =
        jsonParser.fromJson<Number>(
            number,
            object : TypeToken<Number>() {}.type
        )!!

    @TypeConverter
    fun fromCountry(country: Country): String =
        jsonParser.toJson<Country>(
            country,
            object : TypeToken<Country>() {}.type
        ) ?: "[]"

    @TypeConverter
    fun toCountry(country: String): Country =
        jsonParser.fromJson<Country>(
            country,
            object : TypeToken<Country>() {}.type
        )!!
}