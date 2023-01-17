package com.rick.binlist.data

import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("/{id}")
    suspend fun fetchBin(
        @Path("id") bin: Int
    ): Bin?

    companion object {
        const val BINLIST_BASE_URL = "https://lookup.binlist.net/"
    }
}