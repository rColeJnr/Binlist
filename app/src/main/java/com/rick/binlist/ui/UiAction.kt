package com.rick.binlist.ui

sealed class UiAction {
    data class EnteredBin(val bin: Int): UiAction()
}
