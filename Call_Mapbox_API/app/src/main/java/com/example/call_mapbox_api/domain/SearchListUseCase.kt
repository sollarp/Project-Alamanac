package com.example.call_mapbox_api.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.call_mapbox_api.homescreen.data.SearchListRepository
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.launch

class SearchListUseCase (
    private val searchListRepository: SearchListRepository ) {

    var listOfItems = MutableLiveData<List<EvPointDetails>>()


    suspend fun getElements() {
        return searchListRepository.getlatestList().collect { items ->
            listOfItems.postValue(items)
        }
    }
}