package com.example.call_mapbox_api.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

        var mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        var mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()
//    var gsonBuilder = GsonBuilder()
//    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient();


        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.openchargemap.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build()
        }
    val evList : OpenMapApi by lazy {
        retrofit.create(OpenMapApi::class.java)
    }
}