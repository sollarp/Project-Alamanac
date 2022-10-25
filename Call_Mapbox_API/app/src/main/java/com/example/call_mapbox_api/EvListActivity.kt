package com.example.call_mapbox_api

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.api.RetrofitClient
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.remote.EvPointsBrakeItemX
import com.example.call_mapbox_api.remote.toEvPointDetails
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

class EvListActivity: AppCompatActivity(){
    private lateinit var itemParsed: ArrayList<EvPointDetails>
    private var json = Json { ignoreUnknownKeys = true }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_evlist)
        getItemsFromApi()
    }
    fun getItemsFromApi() {
        lifecycleScope.launchWhenCreated {
            try {
                val response = RetrofitClient.evList.getMaxResults()
                if (response.isSuccessful) {
                    val jsonResult = response.body()
                    val resultToJson = json.encodeToJsonElement(jsonResult)
                    val resultFromJson = json.decodeFromJsonElement<List<EvPointsBrakeItemX>>(resultToJson)
                    val listOfPoints = resultFromJson.toEvPointDetails()
                    itemParsed = listOfPoints as ArrayList<EvPointDetails>
                    itemParsed.let {
                        val adapter = MainAdapter(itemParsed)
                        val recyclerView = findViewById<RecyclerView>(R.id.id_recycler)
                        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                        recyclerView.adapter = adapter
                    }
                } else {
                    Toast.makeText(
                        this@EvListActivity,
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
