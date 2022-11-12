package com.example.call_mapbox_api.ui
import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.call_mapbox_api.data.SearchListRepository
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.launch
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.VIEW_MODEL_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.call_mapbox_api.MyApplication


class SearchListViewModel(
    private val searchListRepository: SearchListRepository,
    private val savedStateHandle: SavedStateHandle

): ViewModel() {

    var listOfItems = MutableLiveData<List<EvPointDetails>>()


    init {
        viewModelScope.launch {
            getElements()
        }
    }

    suspend fun getElements() {
        return searchListRepository.LatestList.collect { items ->
            listOfItems.postValue(items)
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
                // Get the Application object from extras
                val application = checkNotNull(extras[SAVED_STATE_REGISTRY_OWNER_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return SearchListViewModel(
                    MyApplication().repo,
                    savedStateHandle
                ) as T
            }
        }
    }
}