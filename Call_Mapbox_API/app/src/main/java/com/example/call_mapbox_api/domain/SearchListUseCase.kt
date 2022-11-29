package com.example.call_mapbox_api.domain

import androidx.lifecycle.MutableLiveData
import com.example.call_mapbox_api.homescreen.data.ISearchListRepository
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.model.toEvPointDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SearchListUseCase (
    private val searchListRepository: ISearchListRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default) : ISearchListUseCase
{

    override suspend operator fun invoke(): Flow<List<EvPointDetails>> =
        withContext(dispatcher) {
            searchListRepository.fetchList().map { items -> items.toEvPointDetails() }
            }

        // TODO: map data models to item view models
    }

interface ISearchListUseCase {
    suspend operator fun invoke(): Flow<List<EvPointDetails>>
}
