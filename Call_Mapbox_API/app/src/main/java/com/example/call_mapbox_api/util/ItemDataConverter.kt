package com.example.call_mapbox_api.util


import com.example.call_mapbox_api.remote.ConnectionX
import java.io.Serializable


data class ItemDataConverter(
    val AddressLine1: String?,
    val AddressLine2: String?,
    val Latitude: Double?,
    val Longitude: Double?,
    val Postcode: String?,
    val Title: String?,
    val Town: String?,
    val UsageCost: String?,
    val NumberOfPoints: Int?,
    val DateLastStatusUpdate: String?,
    val Connection: List<ConnectionX>?
): Serializable



