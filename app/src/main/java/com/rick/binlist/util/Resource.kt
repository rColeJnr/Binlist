package com.rick.binlist.util

import com.rick.binlist.data.Bin

sealed class Resource {
    data class Success(val data: List<Bin>): Resource()
    data class Error(val message: String?): Resource()
    data class Loading(val isLoading: Boolean = false): Resource()
}