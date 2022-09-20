package com.example.call_mapbox_api

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.call_mapbox_api.api.RetrofitClient
import com.example.call_mapbox_api.remote.*
import com.google.gson.Gson

class MainActivity : AppCompatActivity(){

    lateinit var txtData: TextView
    private var gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtData = findViewById(R.id.txtData)
        getItemsFromApi()
    }
    fun getItemsFromApi() {
        lifecycleScope.launchWhenCreated {
            try {
                val response = RetrofitClient.evList.getMaxResults()
                if (response.isSuccessful) {
                    """Gson serialization  """
                    val convertJson = gson.toJson(response.body())
                    val tutorial1 = gson.fromJson(convertJson, EvPointsBrakeX::class.java)
                    println("response body show = ${response.body()} ")
                    println("itemParsed = $convertJson ")
                    val itemParsed = tutorial1.map { it.UUID }
                    txtData.text = itemParsed[0].toString()
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
