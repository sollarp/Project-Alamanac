package com.example.call_mapbox_api.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class EvPointsBrakeItem(
    @SerialName("AddressInfo")
    val addressInfo: AddressInfo,
    @SerialName("Connections")
    val connections: List<Connection>,
    @SerialName("DataProviderID")
    val dataProviderID: Int,
    @SerialName("DataQualityLevel")
    val dataQualityLevel: Int,
    @SerialName("DateCreated")
    val dateCreated: String,
    @SerialName("DateLastStatusUpdate")
    val dateLastStatusUpdate: String,
    @SerialName("DateLastVerified")
    val dateLastVerified: String,
    @SerialName("ID")
    val iD: Int,
    @SerialName("IsRecentlyVerified")
    val isRecentlyVerified: Boolean,
    @SerialName("NumberOfPoints")
    val numberOfPoints: Int,
    @SerialName("OperatorID")
    val operatorID: Int,
    @SerialName("OperatorsReference")
    val operatorsReference: String,
    @SerialName("StatusTypeID")
    val statusTypeID: Int,
    @SerialName("SubmissionStatusTypeID")
    val submissionStatusTypeID: Int,
    @SerialName("UUID")
    val uUID: String,
    @SerialName("UsageCost")
    val usageCost: String,
    @SerialName("UsageTypeID")
    val usageTypeID: Int
)