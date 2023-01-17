package com.rick.binlist.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rick.binlist.data.BinRepositoryImpl
import com.rick.binlist.util.BinSearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinViewModel @Inject constructor(
    private val repo: BinRepositoryImpl
): ViewModel() {

    init {
        viewModelScope.launch{
            repo.fetchBin(45717360).collect { result ->
                when (result) {
                    is BinSearchResult.Success -> {
                        Log.i("TGAG", "result -> ${result.data.first()}")
                    }
                }
            }

        }
    }

}