package com.example.call_mapbox_api.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Connection(
    @SerialName("Amps")
    val amps: Int,
    @SerialName("ConnectionTypeID")
    val connectionTypeID: Int,
    @SerialName("CurrentTypeID")
    val currentTypeID: Int,
    @SerialName("ID")
    val iD: Int,
    @SerialName("LevelID")
    val levelID: Int,
    @SerialName("PowerKW")
    val powerKW: Double,
    @SerialName("Quantity")
    val quantity: Int,
    @SerialName("StatusTypeID")
    val statusTypeID: Int,
    @SerialName("Voltage")
    val voltage: Int
)