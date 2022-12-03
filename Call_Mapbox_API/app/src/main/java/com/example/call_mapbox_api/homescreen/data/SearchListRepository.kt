package com.example.call_mapbox_api.homescreen.data

import com.example.call_mapbox_api.remote.EvPointsBrakeItem
import kotlinx.coroutines.flow.Flow


class SearchListRepository(
    private val evPointDataSource: IEvPointDataSource,
    //private val localData: LocalData
) : ISearchListRepository {

    override suspend fun fetchList(): Flow<List<EvPointsBrakeItem>> =
        evPointDataSource.getLatestEvPoint()
}

interface ISearchListRepository {
    suspend fun fetchList(): Flow<List<EvPointsBrakeItem>>
}

