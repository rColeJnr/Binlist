package com.rick.binlist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBin(bin : List<Bin>)

    @Query("DELETE FROM bin_db")
    suspend fun clearBins()

    @Query("SELECT * FROM bin_db WHERE id LIKE :id")
    suspend fun getBin(id: Long) : Bin

}