package com.example.call_mapbox_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.call_mapbox_api.model.EvPointDetails
import java.util.*
import kotlin.collections.ArrayList

class SearchRecycleAdapter(private val address: ArrayList<EvPointDetails>) :
    RecyclerView.Adapter<SearchRecycleAdapter.ViewHolder>() {



    val items = " "
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.list_view)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater
            .inflate(R.layout.fragment_searchlist, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val items = address.map {
            it.AddressInfo?.AddressLine1 + ", " +
                    it.AddressInfo?.AddressLine2 + ", " +
                    it.AddressInfo?.Town + ", " +
                    it.AddressInfo?.Postcode
        }
        viewHolder.textView.text = items[position].toString()
        /*val item = address[position]
        viewHolder.textView.text = item.AddressInfo?.Postcode.toString()*/

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = address.size





}

