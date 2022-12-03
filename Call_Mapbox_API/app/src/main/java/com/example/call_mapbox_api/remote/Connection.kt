package com.example.call_mapbox_api.remote


import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Connection(
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