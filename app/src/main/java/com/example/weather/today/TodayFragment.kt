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
import java.lang.Exception
import kotlin.math.log

class TodayFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val map = mutableMapOf<String, String>()
        map["q"] = "Malda"
        map["appid"] = API_KEY
        try {
            val result = WeatherApi.retrofitService.getForecast(map)
            Log.d("TodayFragment", "onCreateView: $result")
        } catch (e: Exception) {
            Log.d("TodayFragment", "Exception: ${e.message}")
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }
}