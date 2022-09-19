package com.example.call_mapbox_api

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.call_mapbox_api.api.RetrofitClient
import com.example.call_mapbox_api.remote.EvPointsBrakeItem
import com.example.call_mapbox_api.remote.EvPointsBrakeItemX
import com.example.call_mapbox_api.remote.EvPointsBrakeX
import com.example.call_mapbox_api.remote.Tutorial
import com.google.gson.Gson
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement


class MainActivity : AppCompatActivity(){

    private var json = Json //{ ignoreUnknownKeys = false }
    lateinit var txtData: TextView
    private var gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtData = findViewById(R.id.txtData)

        getPointList()
    }

    fun getPointList() {

        lifecycleScope.launchWhenCreated {
            try {
                val response = RetrofitClient.evList.getMaxResults()

                if (response.isSuccessful) {
                    val json2 = """{"IsRecentlyVerified":false,"DateLastVerified":"2019-03-06T06:28:00Z","ID":53069,"UUID":"DD3779B3-2CDB-465B-9A64-A34864AF178D","DataProviderID":1,"OperatorID":32,"OperatorsReference":"189","UsageTypeID":4,"UsageCost":"Inclusive; for Polar Plus subscription members only. £1.70 per hour for type 2. Parking fees apply","AddressInfo":{"ID":53415,"Title":"Worcester Street Car Park","AddressLine1":"Worcester Street","AddressLine2":"Jericho","Town":"Oxford","StateOrProvince":"Oxfordshire","Postcode":"OX1 1JD","CountryID":1,"Latitude":51.752602,"Longitude":-1.26586,"Distance":0.25286273669530807,"DistanceUnit":2},"Connections":[{"ID":66150,"ConnectionTypeID":3,"StatusTypeID":50,"LevelID":2,"Amps":13,"Voltage":230,"PowerKW":3.0,"CurrentTypeID":10,"Quantity":1},{"ID":66151,"ConnectionTypeID":25,"StatusTypeID":50,"LevelID":2,"Amps":32,"Voltage":230,"PowerKW":7.0,"CurrentTypeID":10,"Quantity":1}],"NumberOfPoints":1,"StatusTypeID":50,"DateLastStatusUpdate":"2019-03-06T06:28:00Z","DataQualityLevel":1,"DateCreated":"2015-09-19T15:07:00Z","SubmissionStatusTypeID":200}"""
                    val json3 = """{"AddressInfo":{"AddressLine1":"Worcester Street","AddressLine2":"Jericho","CountryID":1,"DistanceUnit":2,"Distance":0.25286273669530807,"ID":53415,"Latitude":51.752602,"Longitude":-1.26586,"Postcode":"OX1 1JD","StateOrProvince":"Oxfordshire","Title":"Worcester Street Car Park","Town":"Oxford"},"Connections":[{"ConnectionTypeID":3,"CurrentTypeID":10,"ID":66150,"Voltage":230,"Amps":13,"LevelID":2,"PowerKW":3.0,"Quantity":1,"StatusTypeID":50},{"ConnectionTypeID":25,"CurrentTypeID":10,"ID":66151,"Voltage":230,"Amps":32,"LevelID":2,"PowerKW":7.0,"Quantity":1,"StatusTypeID":50}],"DataProviderID":1,"DataQualityLevel":1,"DateCreated":"2015-09-19T15:07:00Z","DateLastStatusUpdate":"2019-03-06T06:28:00Z","DateLastVerified":"2019-03-06T06:28:00Z","ID":53069,"IsRecentlyVerified":false,"NumberOfPoints":1,"OperatorID":32,"OperatorsReference":"189","StatusTypeID":50,"SubmissionStatusTypeID":200,"UUID":"DD3779B3-2CDB-465B-9A64-A34864AF178D","UsageCost":"Inclusive; for Polar Plus subscription members only. £1.70 per hour for type 2. Parking fees apply","UsageTypeID":4}"""
                    val json1 = """{"title": "Kotlin Tutorial #1"}"""
                    val json0 =  response.body()
                    val json00 = json.encodeToString(json3)

//                    println(json0)
                    println(json00)

//                    val obj = json.decodeFromString<EvPointsBrakeItem>(json3)
//
//                    txtData.text = obj.uUID

                    /*"""Gson serialization  """
                    val convertJson = gson.toJson(response.body())
                    val tutorial1 = gson.fromJson(convertJson, EvPointsBrakeX::class.java)
                    val itemParsed = tutorial1.map { it.AddressInfo?.Latitude }
                    txtData.text = itemParsed.toString()
                    """*/

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Ex.localizedMessage?.let { Log.e("Error", it) }
            }
        }

    }

}
