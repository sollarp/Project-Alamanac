package com.example.call_mapbox_api.model

import com.example.call_mapbox_api.Connection
import com.example.call_mapbox_api.remote.AddressInfoX
import com.example.call_mapbox_api.remote.ConnectionX
import com.example.call_mapbox_api.remote.EvPointsBrakeItemX
import kotlinx.serialization.Serializable

@Serializable
data class EvPointDetails(
    val DataProviderID: Int?,
    val DataQualityLevel: Int?,
    val DateCreated: String?,
    val DateLastStatusUpdate: String?,
    val DateLastVerified: String?,
    val ID: Int?,
    val IsRecentlyVerified: Boolean?,
    val NumberOfPoints: Int?,
    val OperatorID: Int?,
    val StatusTypeID: Int?,
    val SubmissionStatusTypeID: Int?,
    val UUID: String?,
    val UsageCost: String?,
    val UsageTypeID: Int?,
    val AddressInfo: AddressInfoX?,
    val Connection: List<ConnectionX>?
)

fun List<EvPointsBrakeItemX>.toEvPointDetails() : List<EvPointDetails> {
    return this.map {
        EvPointDetails(
            AddressInfo = it.AddressInfo,
            Connection = it.Connections,
            NumberOfPoints = it.NumberOfPoints,
            ID = it.ID,
            StatusTypeID = it.StatusTypeID,
            UsageCost = it.UsageCost,
            UUID = it.UUID,
            OperatorID = it.OperatorID,
            IsRecentlyVerified = it.IsRecentlyVerified,
            DataProviderID = it.DataProviderID,
            DataQualityLevel = it.DataQualityLevel,
            DateCreated = it.DateCreated,
            DateLastStatusUpdate = it.DateLastStatusUpdate,
            DateLastVerified = it.DateLastVerified,
            UsageTypeID = it.UsageTypeID,
            SubmissionStatusTypeID = it.SubmissionStatusTypeID
        )
    }
}