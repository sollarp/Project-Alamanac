package com.example.call_mapbox_api.homescreen.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.Connection
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.databinding.FragmentDetailBinding
import com.example.call_mapbox_api.homescreen.data.DetailRecycleAdapter
import com.example.call_mapbox_api.util.ItemDataConverter


class DetailFragment : Fragment() {

    private lateinit var listDataConvert: ArrayList<Connection>
    private var fragmentDetailBinding: FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        fragmentDetailBinding = binding

        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getSerializable("data") as ItemDataConverter

            val add1 = view.findViewById<TextView>(R.id.addressline1)
            val add2 = view.findViewById<TextView>(R.id.addressline2)
            val town = view.findViewById<TextView>(R.id.town)
            val tile = view.findViewById<TextView>(R.id.title)
            val cost = view.findViewById<TextView>(R.id.usage_cost)
            val bays = view.findViewById<TextView>(R.id.number_of_bays)
            val postCode = view.findViewById<TextView>(R.id.postcode)
            val lon = view.findViewById<TextView>(R.id.latitude)
            val lat = view.findViewById<TextView>(R.id.longitude)
            val lastUpdate = view.findViewById<TextView>(R.id.dateLastStatusUpdate)

            add1.text = result.AddressLine1
            add2.text = result.AddressLine2
            town.text = result.Town
            tile.text = result.Postcode
            cost.text = result.UsageCost
            bays.text = result.NumberOfPoints.toString()
            postCode.text = result.Title
            lon.text = result.Longitude.toString()
            lat.text = result.Latitude.toString()
            lastUpdate.text = result.DateLastStatusUpdate

            val adapter = result.Connection?.let { DetailRecycleAdapter(it) }
            val recyclerView = view.findViewById<RecyclerView>(R.id.connection_recycler)
            recyclerView.layoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            recyclerView.adapter = adapter

        }

        return view
    }


}