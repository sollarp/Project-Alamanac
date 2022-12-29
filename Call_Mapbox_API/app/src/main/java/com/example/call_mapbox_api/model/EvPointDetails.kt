package com.example.call_mapbox_api.model

import com.example.call_mapbox_api.data.remote.AddressInfo
import com.example.call_mapbox_api.data.remote.Connections
import com.example.call_mapbox_api.data.remote.EvPointsBrakeItem
import kotlinx.serialization.Serializable

// This class has not been used. Room using EvPointsBreakItems

@Serializable
data class EvPointDetails(
    val ID: Int?,
    val DateLastVerified: String,
    val DataProviderID: Int?,
    val DataQualityLevel: Int?,
    val DateCreated: String?,
    val DateLastStatusUpdate: String?,
    val NumberOfPoints: Int?,
    val IsRecentlyVerified: Boolean?,
    val OperatorID: Int?,
    val StatusTypeID: Int?,
    val SubmissionStatusTypeID: Int?,
    val UUID: String?,
    val UsageCost: String?,
    val UsageTypeID: Int?,
    val AddressInfo: AddressInfo,
    val Connections: List<Connections>
)

fun List<EvPointDetails>.toEvPointsBreakItems() : List<EvPointsBrakeItem> {
    return this.map {
        EvPointsBrakeItem(
            AddressInfo = it.AddressInfo,
            Connections = it.Connections,
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


