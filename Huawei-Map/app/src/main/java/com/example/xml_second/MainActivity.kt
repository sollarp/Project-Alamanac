package com.example.xml_second

import android.Manifest
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.xml_second.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.huawei.hmf.tasks.OnSuccessListener
import com.huawei.hms.location.*
import com.huawei.hms.maps.*
import com.huawei.hms.maps.model.*
import com.huawei.hms.site.api.SearchResultListener
import com.huawei.hms.site.api.SearchService
import com.huawei.hms.site.api.SearchServiceFactory
import com.huawei.hms.site.api.model.*
import java.io.UnsupportedEncodingException
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.net.URLEncoder
import java.util.*


class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var huaweiMap: HuaweiMap
    private lateinit var binding: ActivityMainBinding
    var lng : Double = 0.0
    var ltt : Double = 0.0
    private lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    private var currentLatLng = LatLng(51.51710869310677, -0.1570211124692802)
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MapsInitializer.initialize(this)
        MapsInitializer.setApiKey("DAEDAKLnHAwsi1oGcz2U62DWvM03dyE4reImFpvIrqpfLLFLuxZzU+S5jmZ4PA6EjM5Zoo4AbxGKHyg0QVOq/1vUEb6K0jf4X3sE5g==")
        mFusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(baseContext)
        // check location permission
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
            Log.i(TAG, "sdk < 28 Q")
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val strings = arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
                ActivityCompat.requestPermissions(this, strings, 1)
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val strings = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                ActivityCompat.requestPermissions(this, strings, 3)
            } else {
                ActivityResultContracts.RequestPermission()
            }
        } else {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    "android.permission.ACCESS_BACKGROUND_LOCATION"
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val strings = arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    "android.permission.ACCESS_BACKGROUND_LOCATION"
                )
                ActivityCompat.requestPermissions(this, strings, 2)
            }
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        resultText = findViewById(R.id.button_text_search)

        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_BUNDLE_KEY)
        }
        binding.huaweiMapView.onCreate(mapViewBundle)
        binding.huaweiMapView.getMapAsync(this)
        getLastLocation()

    }
    private fun getLastLocation() {
            try {
            val lastLocation =
                mFusedLocationProviderClient.lastLocation
            lastLocation?.addOnSuccessListener(OnSuccessListener { location ->
                if (location == null) {
                    Log.i(TAG, "getLastLocation onSuccess location is null" )
                    return@OnSuccessListener
                }
                lng = location.longitude
                ltt = location.latitude
                val build = CameraPosition.Builder()
                    .target(LatLng(ltt, lng))
                    .zoom(15f)
                    .bearing(90f)
                    .tilt(30f)
                    .build()
                val cameraUpdate = CameraUpdateFactory.newCameraPosition(build)
                huaweiMap.animateCamera(cameraUpdate)
               //cameraUpdate = CameraUpdateFactory.newCameraPosition(CameraPosition.builder().target(LatLng(ltt, lng)).zoom(7f).build())
                huaweiMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    LatLng(ltt, lng), 15f))

                Log.i(
                    TAG,
                    "getLastLocation onSuccess location[Longitude,Latitude]:" +
                            "${location.longitude}," +
                            "${location.latitude}," +
                            "${lastLocation.result}"
                )
                return@OnSuccessListener
            })?.addOnFailureListener { e: Exception ->
                Log.e(TAG, "getLastLocation onFailure:" + e.message)
            }
        } catch (e: Exception) {
            Log.e(TAG, "getLastLocation exception:${e.message}")
        }
    }
    // Moves camera to position location
    /*override fun onMapReady(map: HuaweiMap) {

        //mapping
        huaweiMap = map

        //marker add
        marker = huaweiMap.addMarker(
            MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker()) //default marker
                .title("Huawei Turkey") // maker title
                .position(LatLng(41.031261, 29.117277)) //marker position

        )
        //camera position settings
        cameraPosition = CameraPosition.builder()
            .target(LatLng(41.031261, 29.117277))
            .zoom(10f)
            .bearing(2.0f)
            .tilt(2.5f).build()
        cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        huaweiMap.moveCamera(cameraUpdate)

    }*/
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var mapViewBundle = outState.getBundle(MAP_BUNDLE_KEY)
        if (mapViewBundle == null) {
            mapViewBundle = Bundle()
            outState.putBundle(MAP_BUNDLE_KEY, mapViewBundle)
        }
        binding.huaweiMapView.onSaveInstanceState(mapViewBundle)
    }

    override fun onMapReady(map: HuaweiMap) {
        huaweiMap = map
        val build = CameraPosition.Builder().target(currentLatLng).zoom(10f).build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(build)
        huaweiMap.moveCamera(cameraUpdate)
        // Color of cluster
        huaweiMap.uiSettings.setMarkerClusterColor(Color.BLUE)
        huaweiMap.isMyLocationEnabled = true
        huaweiMap.uiSettings.isMapToolbarEnabled = true
        huaweiMap.uiSettings.isCompassEnabled = true
        huaweiMap.uiSettings?.isMyLocationButtonEnabled = true
         //Add the markers to the cluster future list of position.
        huaweiMap.addMarker(MarkerOptions().position(LatLng(48.891478, 2.334595)).title("Marker1").clusterable(true).snippet("word"))
        huaweiMap.addMarker(MarkerOptions().position(LatLng(48.892478, 2.334595)).title("Marker2").clusterable(true))
        huaweiMap.addMarker(MarkerOptions().position(LatLng(48.893478, 2.334595)).title("Marker3").clusterable(true))
        huaweiMap.addMarker(MarkerOptions().position(LatLng(48.894478, 2.334595)).title("Marker4").clusterable(true))
        huaweiMap.addMarker(MarkerOptions().position(LatLng(48.895478, 2.334595)).title("Marker5").clusterable(true))
        huaweiMap.addMarker(MarkerOptions().position(LatLng(48.896478, 2.334595)).title("Marker6").clusterable(true))
        // Set whether a marker can be clustered.
        huaweiMap.setMarkersClustering(true)
        huaweiMap.setOnMarkerClickListener { marker ->
            Toast.makeText(applicationContext, "onMarkerClick:${marker.title}", Toast.LENGTH_SHORT).show()
            false
        }
        //getLastLocation()
        //Customizing the Icon of the Cluster Marker
        //huaweiMap.uiSettings.setMarkerClusterIcon(BitmapDescriptorFactory.fromResource(R.drawable.avocado))
        //Customizing the Text Color of the Cluster Marker
        //huaweiMap.uiSettings.setMarkerClusterTextColor(Color.RED)
        /**
        val mParis: Marker = hMap.addMarker(MarkerOptions().position(LatLng(48.893478, 2.334595)).title("paris").snippet("hello"))

        // Define the animation transparency effect.
        val alphaAnimation: Animation = AlphaAnimation(0.2f, 1.0f)
        alphaAnimation.repeatCount = 5
        alphaAnimation.duration = 1000L
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart() {
                Log.d(TAG, "Alpha Animation Start")
            }
            override fun onAnimationEnd() {
                Log.d(TAG, "Alpha Animation End")
            }
        })
        // Define the animation zooming effect.
        val scaleAnimation: Animation = ScaleAnimation(0f, 2f, 0f, 2f)
        scaleAnimation.repeatCount = 10
        scaleAnimation.duration = 1000L
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart() {
                Log.d(TAG, "Scale Animation Start")
            }
            override fun onAnimationEnd() {
                Log.d(TAG, "Scale Animation End")
            }
        })
        val animationSet = AnimationSet(true)
        animationSet.interpolator = LinearInterpolator()
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(scaleAnimation)

        // Set the animation effect for a marker.
        mParis.setAnimation(animationSet)
        // Start the animation.
        mParis.startAnimation()**/

    }

    companion object {
        private const val MAP_BUNDLE_KEY = "MapBundleKey"
    }
}