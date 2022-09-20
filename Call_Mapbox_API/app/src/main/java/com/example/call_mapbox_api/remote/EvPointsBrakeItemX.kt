package com.example.call_mapbox_api.remote


import android.os.Parcel
import androidx.annotation.Keep
import android.os.Parcelable
import com.example.call_mapbox_api.model.EvPoints
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable
import okhttp3.internal.ignoreIoExceptions

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

/*
fun List<EvPointsBrakeItemX>.toEvPoints() : String {
    return this.map {
        EvPointsBrakeItemX(
            AddressInfo = it.AddressInfo,
            Connections = it.Connections,
            DataProviderID = it.DataProviderID,
            DataQualityLevel = it.DataQualityLevel,
            DateCreated = it.DateCreated,
            DateLastStatusUpdate = it.DateLastStatusUpdate,
            DateLastVerified = it.DateLastVerified,
            GeneralComments = it.GeneralComments,
            ID = it.ID,
            IsRecentlyVerified = it.IsRecentlyVerified,
            NumberOfPoints = it.NumberOfPoints,
            OperatorID = it.OperatorID,
            OperatorsReference = it.OperatorsReference,
            StatusTypeID = it.StatusTypeID,
            SubmissionStatusTypeID = it.SubmissionStatusTypeID,
            UUID = it.UUID,
            UsageCost = it.UsageCost,
            UsageTypeID = it.UsageTypeID
        )
    }.toString()
}*/
