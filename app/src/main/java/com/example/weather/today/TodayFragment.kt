package com.example.weather.today

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weather.R
import com.example.weather.network.API_KEY
import com.example.weather.network.WeatherApi
import com.example.weather.network.WeatherDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodayFragment : Fragment() {
    val TAG = "TodayFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val map = mutableMapOf<String, String>()
        map["q"] = "Malda"
        map["appid"] = API_KEY

        WeatherApi.retrofitService.getForecast(map).enqueue(object : Callback<WeatherDto> {
            override fun onResponse(
                call: Call<WeatherDto>,
                response: Response<WeatherDto>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")


            }

            override fun onFailure(call: Call<WeatherDto>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }
}