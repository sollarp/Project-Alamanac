package com.example.call_mapbox_api

import android.app.Application
import com.example.call_mapbox_api.domain.SearchListUseCase
import com.example.call_mapbox_api.homescreen.data.SearchListRepository
import com.example.call_mapbox_api.util.AppContainer

class MyApplication: Application() {

    fun getMyApp(): SearchListUseCase{
        return AppContainer().getSearchListUseCase()

    }
}