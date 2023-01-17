package com.rick.binlist.ui

import com.rick.binlist.data.Bin
import com.rick.binlist.util.Resource
import kotlinx.coroutines.flow.Flow

interface IBinRepository {

    suspend fun fetchBin(bin: Int): Flow<Resource>

    suspend fun getBin(id: Long): Bin?

    suspend fun getBins(): List<Bin>

    suspend fun saveBin(bin: Bin)

    suspend fun deleteBin(bin: Bin)

}