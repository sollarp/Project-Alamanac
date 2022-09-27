package com.example.call_mapbox_api.api

import com.example.call_mapbox_api.remote.EvPointsBrakeItemX
import retrofit2.Response
import retrofit2.http.GET

interface OpenMapApi {
    @GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&maxresults=50&compact=true&verbose=false&longitude=-1.260406976465403&latitude=51.754015044041914")
    suspend fun getMaxResults(): Response<List<EvPointsBrakeItemX>>

//    @GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&compact=true&verbose=false")
//    suspend fun getDistance(@Query("distance") distance: Number,
//                            @Query("latitude") latitude: Double,
//                            @Query("longitude") longitude: Double
//    ): List<EvPointsBrakeItemX>>>

}