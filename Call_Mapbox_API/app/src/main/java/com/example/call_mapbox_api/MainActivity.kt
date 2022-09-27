package com.example.call_mapbox_api

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.api.RetrofitClient
import com.example.call_mapbox_api.model.EvPoints
import com.example.call_mapbox_api.remote.*
import com.google.gson.Gson
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

class MainActivity : AppCompatActivity(){

    private var gson = Gson()
    private lateinit var itemParsed: List<EvPoints>
    private var json = Json { ignoreUnknownKeys = true }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)
        getItemsFromApi()
    }
    fun getItemsFromApi() {
        lifecycleScope.launchWhenCreated {
            try {
                val response = RetrofitClient.evList.getMaxResults()
                if (response.isSuccessful) {
                    """Gson serialization  """
//                    val convertJson = gson.toJson(response.body())
//                    val tutorial1 = gson.fromJson(convertJson, EvPointsBrakeX::class.java)
                    val jsonResult = response.body()
                    val resultToJson = json.encodeToJsonElement(jsonResult)
//                    println("response body show = ${response.body()} ")
//                    println("itemParsed = $convertJson ")
                    val resultFromJson = json.decodeFromJsonElement<List<EvPointsBrakeItemX>>(resultToJson)
                    //val tutorial2 = tutorial1.toEvPoints()
                    val listOfPoints = resultFromJson.toEvPoints()
                    itemParsed = listOfPoints

                    itemParsed.let {
                        val adapter = MainAdapter(itemParsed)
                        val recyclerView = findViewById<RecyclerView>(R.id.id_recycler)
                        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                        recyclerView.adapter = adapter
                    }
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
