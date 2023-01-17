package com.rick.binlist.ui

import com.rick.binlist.data.Bin
import kotlinx.coroutines.flow.Flow

interface IBinRepository {

    suspend fun fetchBin(bin: Int): Flow<Result<Bin>>

    suspend fun getBin(id: Long): Bin?

    suspend fun saveBin(bin: Bin)

    suspend fun deleteBin(bin: Bin)

}