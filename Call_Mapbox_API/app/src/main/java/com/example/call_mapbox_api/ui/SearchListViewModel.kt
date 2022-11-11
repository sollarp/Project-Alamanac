package com.example.call_mapbox_api.ui
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.test.core.app.launchActivity
import com.example.call_mapbox_api.data.SearchListRepository
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class SearchListViewModel(
    private val searchListRepository: SearchListRepository
    ): ViewModel() {

    var listOfItems = MutableLiveData<List<EvPointDetails>>()

    init {
        viewModelScope.launch {
            getElements()
        }

        }

    suspend fun getElements() {
        return searchListRepository.LatestList.collect{
            items -> listOfItems.postValue(items)
        }


    }
}

        /*fun getElements(){
            viewModelScope.launch {
                // Trigger the flow and consume its elements using collect
                searchListRepository.LatestList.collect { latestList ->
                    myLiveData = latestList
                    // Update View with the latest favorite news
                }
            }
        }*/

//    private val searchListRepository: SearchListRepository
//        get() {
//            return searchListRepository
//        }

    /*init {
        viewModelScope.launch {
            // Trigger the flow and consume its elements using collect
            searchListRepository.LatestList.collect { latestList ->
                println(latestList)
                // Update View with the latest favorite news
            }
        }
    }*/

