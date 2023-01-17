package com.rick.binlist.ui

import com.rick.binlist.data.Bin
import retrofit2.http.GET
import retrofit2.http.Query

interface BinApi {

    @GET("/")
    suspend fun fetchBin(
        @Query("") bin: Int
    ): Bin?

    companion object {
        const val BINLIST_BASE_URL = "https://lookup.binlist.net/"
    }
}