package com.example.call_mapbox_api.data

import com.example.call_mapbox_api.api.OpenMapApi
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.util.EvApiParser
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EvPointDataSource(
    val latestEvpoint: OpenMapApi,
    private val refreshIntervalMs: Long = 5000
) {
        val latestEVPoint: Flow<List<EvPointDetails>> = flow {
        val result = latestEvpoint.getMaxResults()
        while(true) {
            val getLatestEvpoint = EvApiParser(result)
            emit(getLatestEvpoint) // Emits the result of the request to the flow
            delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }
}
