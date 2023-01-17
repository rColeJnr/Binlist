package com.rick.binlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rick.binlist.data.BinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinViewModel @Inject constructor(
    private val repo: BinRepositoryImpl
): ViewModel() {

    init {
        viewModelScope.launch{
            repo.fetchBin(45717360)
        }
    }

}