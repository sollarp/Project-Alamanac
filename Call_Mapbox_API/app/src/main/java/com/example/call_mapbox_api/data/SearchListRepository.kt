package com.example.call_mapbox_api.data

import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.shareIn

class SearchListRepository(
    evPointDataSource: EvPointDataSource,
    //externalScope: CoroutineScope

    // For Local Data store later
    //private val localData: LocalData
) {
    /**
     * Returns the favorite latest news applying transformations on the flow.
     * These operations are lazy and don't trigger the flow. They just transform
     * the current value emitted by the flow at that point in time.
     */
//    val LatestList: Flow<List<EvPointDetails>> =
//        evPointDataSource.latestEVPoint.shareIn (externalScope, WhileSubscribed())

    val LatestList: Flow<List<EvPointDetails>> =
        evPointDataSource.latestEVPoint
}
