package com.rick.binlist.ui

import com.rick.binlist.data.Bin

data class UiState(
    val isLoading: Boolean = false,
    val items: List<Bin> = emptyList(),
    val error: String? = null,
)
