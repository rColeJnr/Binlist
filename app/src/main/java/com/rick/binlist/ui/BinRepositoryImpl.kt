package com.rick.binlist.ui

import androidx.room.withTransaction
import com.rick.binlist.data.Bin
import com.rick.binlist.data.BinDatabase
import com.rick.binlist.util.BinSearchResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val db: BinDatabase,
    private val api: BinApi
): IBinRepository {

    override suspend fun fetchBin(bin: Int): Flow<BinSearchResult> {

        var bins: List<Bin> = listOf()

        return flow {

            emit(BinSearchResult.Loading(true))

            try {
                val response = api.fetchBin(bin)
                response?.let {
                    db.withTransaction {
                        saveBin(response)
                        bins = getBins()
                    }
                    emit(BinSearchResult.Success(bins))
                    emit(BinSearchResult.Loading(false))
                }
            } catch (e: IOException) {
                emit(BinSearchResult.Error(e.message))
                emit(BinSearchResult.Loading(false))
            } catch (e: HttpException) {
                emit(BinSearchResult.Error(e.message))
                emit(BinSearchResult.Loading(false))
            }

        }

    }

    override suspend fun getBin(id: Long): Bin? =
        db.binDao.getBin(id)

    override suspend fun getBins(): List<Bin> =
        db.binDao.getBins()

    override suspend fun saveBin(bin: Bin) {
        db.binDao.saveBin(bin)
    }

    override suspend fun deleteBin(bin: Bin) {
        db.binDao.clearBins()
    }
}