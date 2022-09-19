package com.example.call_mapbox_api.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class AddressInfo(
    @SerialName("AddressLine1")
    val addressLine1: String,
    @SerialName("AddressLine2")
    val addressLine2: String,
    @SerialName("CountryID")
    val countryID: Int,
    @SerialName("Distance")
    val distance: Double,
    @SerialName("DistanceUnit")
    val distanceUnit: Int,
    @SerialName("ID")
    val iD: Int,
    @SerialName("Latitude")
    val latitude: Double,
    @SerialName("Longitude")
    val longitude: Double,
    @SerialName("Postcode")
    val postcode: String,
    @SerialName("StateOrProvince")
    val stateOrProvince: String,
    @SerialName("Title")
    val title: String,
    @SerialName("Town")
    val town: String
)