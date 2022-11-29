package com.example.call_mapbox_api.homescreen.data

import androidx.lifecycle.MutableLiveData
import com.example.call_mapbox_api.homescreen.data.EvPointDataSource
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.remote.EvPointsBrakeItemX
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SearchListRepository(
    private val evPointDataSource: EvPointDataSource,
    //private val localData: LocalData
) : ISearchListRepository {

    override suspend fun fetchList(): Flow<List<EvPointsBrakeItemX>> =
        evPointDataSource.getLatestEvPoint()
}

interface ISearchListRepository {
    suspend fun fetchList(): Flow<List<EvPointsBrakeItemX>>
}

