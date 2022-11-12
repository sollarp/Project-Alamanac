package com.example.call_mapbox_api.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.data.SearchRecycleAdapter
import kotlinx.coroutines.launch

class SearchListActivity: AppCompatActivity() {

    private val viewModel: SearchListViewModel by viewModels { SearchListViewModel.Factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchlist)

        lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listOfItems.observe(this@SearchListActivity,
                    Observer {
                        val adapter = SearchRecycleAdapter(it)
                        val recyclerView = findViewById<RecyclerView>(R.id.recycle_search)
                        if (recyclerView != null) {
                            recyclerView.layoutManager =
                                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                        }
                        if (recyclerView != null) {
                            recyclerView.adapter = adapter
                        }
                    })
            }
        }
    }
}