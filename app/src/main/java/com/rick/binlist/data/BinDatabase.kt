package com.rick.binlist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Bin::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class BinDatabase: RoomDatabase() {

    abstract val binDao: BinDao

    companion object {
        const val DATABASE_NAME = "bin_db"
    }

}