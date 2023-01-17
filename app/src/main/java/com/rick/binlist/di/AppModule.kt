package com.rick.binlist.di

import android.content.Context
import androidx.room.Room
import com.rick.binlist.data.*
import com.rick.binlist.data.BinApi.Companion.BINLIST_BASE_URL
import com.rick.binlist.data.BinDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBinApi(): BinApi =
        Retrofit.Builder()
            .baseUrl(BINLIST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BASIC
                    }
                ).build()
            )
            .build()
            .create()

    @Provides
    @Singleton
    fun provideBinDatabase(@ApplicationContext context: Context): BinDatabase =
        Room.databaseBuilder(
            context,
            BinDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideBinRepository(db: BinDatabase, api: BinApi): IBinRepository =
        BinRepositoryImpl(db, api)

}