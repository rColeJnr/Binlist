package com.rick.binlist.ui

import com.rick.binlist.data.Bin
import com.rick.binlist.data.BinDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val db: BinDatabase,
    private val api: BinApi
): IBinRepository {

    override suspend fun fetchBin(bin: Int): Flow<Result<Bin>> {


    }

    override suspend fun getBin(id: Long): Bin? {
        TODO("Not yet implemented")
    }

    override suspend fun saveBin(bin: Bin) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBin(bin: Bin) {
        TODO("Not yet implemented")
    }
}