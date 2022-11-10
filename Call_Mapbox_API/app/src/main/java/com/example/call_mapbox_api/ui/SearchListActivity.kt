package com.example.call_mapbox_api.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.example.call_mapbox_api.R

class SearchListActivity: AppCompatActivity() {

    private val viewModel: SearchListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchlist)
        viewModel.viewModelScope
    }

}





/*private lateinit var itemParsed: ArrayList<EvPointDetails>
private var json = Json { ignoreUnknownKeys = true }*/

    /*val searchBar = findViewById<AutoCompleteTextView>(R.id.input_autosearch)
     val softKey =
         this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
     softKey.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    getItemsFromApi()


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
                        val adapter = SearchRecycleAdapter(itemParsed)
                        val recyclerView = findViewById<RecyclerView>(R.id.recycle_search)
                        if (recyclerView != null) {
                            recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                        }
                        if (recyclerView != null) {
                            recyclerView.adapter = adapter
                        }
                    }
                } else {
                    Toast.makeText(
                        this@SearchListActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                    println("error")
                }
            }catch (Ex:Exception){
                Ex.localizedMessage?.let { Log.e("Error", it) }
            }
        }
    }
}*/