package com.example.call_mapbox_api

import com.example.call_mapbox_api.api.OpenMapApi

class OpenMapRepo(private val openMapApi: OpenMapApi) {
    suspend fun getOpenApiResponed() = openMapApi.getMaxResults()
}