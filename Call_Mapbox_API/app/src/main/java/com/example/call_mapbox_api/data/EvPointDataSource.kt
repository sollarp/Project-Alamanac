package com.example.call_mapbox_api.data

import com.example.call_mapbox_api.data.remote.EvPointsBrakeItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EvPointDataSource(
    private val openMapApi: OpenMapApi,
    private val refreshIntervalMs: Long = 5000
) : IEvPointDataSource {
    override suspend fun getLatestEvPoint(): Flow<List<EvPointsBrakeItem>> {
        return flow {
            val result = openMapApi.getMaxResults()
            emit(result) // Emits the result of the request to the flow
            delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }
}

interface IEvPointDataSource {
    suspend fun getLatestEvPoint(): Flow<List<EvPointsBrakeItem>>
}

