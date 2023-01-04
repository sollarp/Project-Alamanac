package com.example.call_mapbox_api.data.local

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.call_mapbox_api.MyApplication
import com.example.call_mapbox_api.data.remote.EvPointsBrakeItem
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.CoroutineScope


@Database(entities = [EvPointsBrakeItem::class], version = 2, exportSchema = false)
@TypeConverters(ConnectionConverter::class, AddressConverter::class)

abstract class EvPointDataBase : RoomDatabase() {

    abstract fun evPointsDao(): EvPointsDao
}