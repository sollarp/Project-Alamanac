package com.example.call_mapbox_api.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.call_mapbox_api.data.SearchListRepository

import kotlinx.coroutines.launch

class SearchListViewModel(
    private val searchListRepository: SearchListRepository
    ): ViewModel() {
//    private val searchListRepository: SearchListRepository
//        get() {
//            return searchListRepository
//        }

    init {
        viewModelScope.launch {
            // Trigger the flow and consume its elements using collect
            searchListRepository.LatestList.collect { latestList ->
                println(latestList)
                // Update View with the latest favorite news
            }
        }
    }
}