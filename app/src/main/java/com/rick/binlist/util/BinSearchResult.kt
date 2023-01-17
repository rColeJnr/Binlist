package com.rick.binlist.util

import com.rick.binlist.data.Bin

sealed class BinSearchResult {
    data class Success(val data: List<Bin>): BinSearchResult()
    data class Error(val message: String?): BinSearchResult()
    data class Loading(val isLoading: Boolean = false): BinSearchResult()
}