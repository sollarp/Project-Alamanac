package com.example.call_mapbox_api.util

import com.example.call_mapbox_api.api.OpenMapApi
import com.example.call_mapbox_api.api.RetrofitClient
import com.example.call_mapbox_api.data.EvPointDataSource
import com.example.call_mapbox_api.data.SearchListRepository
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.content.Context as AndroidContentContext

class AppContainer{
    // Since you want to expose userRepository out of the container, you need to satisfy
    // its dependencies as you did before
    var mHttpLoggingInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    var mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttpLoggingInterceptor)
        .build()

    //  https://api.openchargemap.io/
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://d01abe6f-6cca-4fc5-aaf9-18b2ff7178f4.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
    }
    val getRetrofit = retrofit.create(OpenMapApi::class.java)

   private val remoteDataSource = EvPointDataSource(getRetrofit)

    //private val localDataSource = UserLocalDataSource()

    // userRepository is not private; it'll be exposed
    val userRepository = SearchListRepository(remoteDataSource)
}