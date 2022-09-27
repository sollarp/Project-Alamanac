package com.example.call_mapbox_api.remote


import androidx.annotation.Keep
import com.example.call_mapbox_api.model.EvPoints
import kotlinx.serialization.Serializable

@Keep
//@Parcelize
//@JsonClass(generateAdapter = true)
@Serializable
data class EvPointsBrakeItemX(
    val AddressInfo: AddressInfoX?,
    val Connections: List<ConnectionX>?,
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
    val UsageCost: String?,
    val UsageTypeID: Int?
)


fun List<EvPointsBrakeItemX>.toEvPoints() : List<EvPoints> {
    return this.map {
        EvPoints(
            ID = it.ID
        )
    }
}
