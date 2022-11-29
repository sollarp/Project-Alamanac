package com.example.call_mapbox_api.homescreen.ui

import androidx.lifecycle.MutableLiveData
import com.example.call_mapbox_api.model.EvPointDetails
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.call_mapbox_api.MyApplication
import com.example.call_mapbox_api.domain.SearchListUseCase
import kotlinx.coroutines.launch

class SearchListViewModel(
    //private val searchListRepository: SearchListRepository,
    private val searchListUseCase: SearchListUseCase
) : ViewModel() {

    var listOfItems = MutableLiveData<List<EvPointDetails>>()

    init {
        viewModelScope.launch {
            getListUseCase()
        }
    }

    suspend fun getListUseCase() {
        searchListUseCase.invoke().collect{
            items -> listOfItems.postValue(items)
        }
    }

    //Define ViewModel factory in a companion object
    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return SearchListViewModel(
                    MyApplication().getMyApp(),
                ) as T
            }
        }
    }
}