package com.example.call_mapbox_api.remote


import android.os.Parcel
import androidx.annotation.Keep
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ConnectionX(
    val ConnectionTypeID: Int?,
    val CurrentTypeID: Int?,
    val ID: Int?,
    val Voltage: Int?,
    val Amps: Int?,
    val LevelID: Int?,
    val PowerKW: Double?,
    val Quantity: Int?,
    val StatusTypeID: Int?
)