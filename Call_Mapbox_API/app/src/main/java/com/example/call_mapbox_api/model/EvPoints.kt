package com.example.call_mapbox_api.model

import com.example.call_mapbox_api.remote.AddressInfoX
import com.example.call_mapbox_api.remote.ConnectionX

data class EvPoints(
    val AddressInfo: AddressInfoX?,
    val Connections: List<ConnectionX>?,
    val DataProviderID: Int?,
    val DataQualityLevel: Int?,
    val DateCreated: String?,
    val DateLastStatusUpdate: String?,
    val DateLastVerified: String?,
    val GeneralComments: String?,
    val ID: Int?,
    val IsRecentlyVerified: Boolean?,
    val NumberOfPoints: Int?,
    val OperatorID: Int?,
    val OperatorsReference: String?,
    val StatusTypeID: Int?,
    val SubmissionStatusTypeID: Int?,
    val UUID: String?,
    val UsageCost: String?,
    val UsageTypeID: Int?
)
