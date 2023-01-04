package com.example.call_mapbox_api.data

import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class EvPointRemoteDataSource
@Inject constructor(private val openMapApi: OpenMapApi) : IEvPointRemoteDataSource {
    //private val refreshIntervalMs: Long = 5000

    override suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>> {
        return flow {
            val result = openMapApi.getMaxResults()
            emit(result) // Emits the result of the request to the flow
            //delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }
}

interface IEvPointRemoteDataSource {
    suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>>
}

