package com.example.call_mapbox_api

import android.app.Application
import com.example.call_mapbox_api.util.AppContainer

class MyApplication: Application() {

    val appContainer = AppContainer()
    val repo = appContainer.userRepository


}