package com.example.call_mapbox_api

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val listDataConvert = intent.getParcelableArrayListExtra<ConnectionList>("ARRAY OF CONNECTIONS")
        println(listDataConvert)
        val itemDataConvert = intent.getSerializableExtra("ALL ITEMS") as ItemDataConverter
        val add1 = findViewById<TextView>(R.id.addressline1)
        val add2 = findViewById<TextView>(R.id.addressline2)
        val town = findViewById<TextView>(R.id.town)
        val tile = findViewById<TextView>(R.id.title)
        val cost = findViewById<TextView>(R.id.usage_cost)
        val bays = findViewById<TextView>(R.id.number_of_bays)
        val postCode = findViewById<TextView>(R.id.postcode)
        val lon = findViewById<TextView>(R.id.latitude)
        val lat = findViewById<TextView>(R.id.longitude)
        val lastUpdate = findViewById<TextView>(R.id.dateLastStatusUpdate)

        add1.text = itemDataConvert.AddressLine1
        add2.text = itemDataConvert.AddressLine2
        town.text = itemDataConvert.Town
        tile.text = itemDataConvert.Postcode
        cost.text = itemDataConvert.UsageCost
        bays.text = itemDataConvert.NumberOfPoints.toString()
        postCode.text = itemDataConvert.Title
        lon.text = itemDataConvert.Longitude.toString()
        lat.text = itemDataConvert.Latitude.toString()
        lastUpdate.text = itemDataConvert.DateLastStatusUpdate




        /*Toast.makeText(
            this,
            "Clicked on : ${itemDataConvert.AddressLine1}",
            Toast.LENGTH_SHORT
        ).show()*/
    }
}