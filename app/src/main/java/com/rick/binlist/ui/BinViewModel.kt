package com.rick.binlist.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rick.binlist.data.BinRepositoryImpl
import com.rick.binlist.util.BinSearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinViewModel @Inject constructor(
    private val repo: BinRepositoryImpl
) : ViewModel() {

    private val _state = mutableStateOf(UiState())
    val state: State<UiState> get() = _state

    init {
        viewModelScope.launch {
            _state.value = UiState(items = repo.getBins())
        }
    }

    private fun fetchBin(bin: Int = 45717360) {
        viewModelScope.launch {
            repo.fetchBin(bin).collectLatest { result ->
                when (result) {
                    is BinSearchResult.Loading -> {
                        _state.value = UiState(isLoading = result.isLoading)
                    }
                    is BinSearchResult.Success -> {
                        _state.value = UiState(items = result.data)
                    }
                    is BinSearchResult.Error -> {
                        _state.value = UiState(error = result.message)
                    }
                }
            }

        }
    }

    fun uiAction(action: UiAction) {
        when (action) {
            is UiAction.EnteredBin -> {
                fetchBin(action.bin)
            }
        }
    }
}

