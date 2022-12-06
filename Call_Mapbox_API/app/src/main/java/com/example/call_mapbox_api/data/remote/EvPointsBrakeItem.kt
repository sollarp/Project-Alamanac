package com.example.call_mapbox_api.data.remote


import androidx.annotation.Keep
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class EvPointsBrakeItem(
    val AddressInfo: AddressInfo,
    val Connections: List<Connection>?,
    val DataProviderID: Int?,
    val DataQualityLevel: Int?,
    val DateCreated: String?,
    val DateLastStatusUpdate: String?,
    val DateLastVerified: String?,
    val ID: Int?,
    val IsRecentlyVerified: Boolean?,
    val NumberOfPoints: Int?,
    val OperatorID: Int?,
    val OperatorsReference: String?,
    val StatusTypeID: Int?,
    val SubmissionStatusTypeID: Int?,
    val UUID: String?,
    val UsageCost: String,
    val UsageTypeID: Int?
)

fun List<EvPointsBrakeItem>.toEvPointDetails() : List<EvPointDetails> {
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