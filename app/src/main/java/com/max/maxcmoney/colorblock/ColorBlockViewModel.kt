package com.max.maxcmoney.colorblock


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.max.maxcmoney.data.Photos
import com.max.maxcmoney.network.VolleyService
import com.max.maxcmoney.util.Logger


private const val BASE_URL = "https://jsonplaceholder.typicode.com"

class ColorBlockViewModel() : ViewModel() {

    private val _photosLiveData = MutableLiveData<List<Photos>>()

    val photosLiveData: LiveData<List<Photos>>
        get() = _photosLiveData

    init {
        getPhotosResult()
    }

    private fun getPhotosResult() {
        val url = "$BASE_URL/photos"

        val stringRequest =
            StringRequest(
                Request.Method.GET, url, Response.Listener<String> { response ->
                    val photos: List<Photos> =
                        Gson().fromJson(response, Array<Photos>::class.java).toList()
                    _photosLiveData.value = photos
                    Logger.d("getPhotosResult Success: ${_photosLiveData.value}")
                },

                Response.ErrorListener { error ->
                    Logger.d("getPhotosResult Error: $error")
                })

        VolleyService.requestQueue.add(stringRequest)
        VolleyService.requestQueue.start()

    }
}