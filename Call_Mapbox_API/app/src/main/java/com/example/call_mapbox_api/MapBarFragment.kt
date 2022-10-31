package com.example.call_mapbox_api

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.call_mapbox_api.databinding.ActivityMapBarBinding

class MapBarFragment: Fragment(R.layout.activity_map_bar){

    private var fragmentMainBinding: ActivityMapBarBinding? = null
    private val binding get() = fragmentMainBinding!!

    val mapViewFragment = MapViewFragment()
    val searchListFragment = SearchListFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMainBinding = ActivityMapBarBinding.inflate(inflater, container, false)
        val view = binding.root
        val searchField = view.findViewById<TextView>(R.id.input_search)
        var transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.mainViewFrame, mapViewFragment)
        transaction?.commit()
        searchField.focusable = View.NOT_FOCUSABLE

        searchField.setOnClickListener( object : View.OnClickListener {
            override fun onClick(p0: View?) {
                transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.mainViewFrame, searchListFragment)
                transaction?.commit()
                val softKey =
                    activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                softKey.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                searchField.focusable = View.FOCUSABLE
            }
        })
        return view
    }
}

/*search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

           override fun onQueryTextSubmit(query: String?): Boolean {
               TODO("Not yet implemented")
           }

           override fun onQueryTextChange(newText: String?): Boolean {
               println("deeeeeee")
               return false
           }
       })*/