package com.example.call_mapbox_api.homescreen.data

import com.example.call_mapbox_api.api.OpenMapApi
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.remote.EvPointsBrakeItemX
import com.example.call_mapbox_api.util.EvApiParser
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EvPointDataSource(
    private val openMapApi: OpenMapApi,
    private val refreshIntervalMs: Long = 5000
): IEvPointDataSource {
    override suspend fun getLatestEvPoint(): Flow<List<EvPointsBrakeItemX>> {
        return flow {
            while (true){
            val result = openMapApi.getMaxResults()
            emit(result) // Emits the result of the request to the flow
            delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }

    }
}
interface IEvPointDataSource{
    suspend fun getLatestEvPoint(): Flow<List<EvPointsBrakeItemX>>
}

