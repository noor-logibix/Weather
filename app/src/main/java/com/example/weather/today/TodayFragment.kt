package com.example.weather.today

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weather.databinding.FragmentTodayBinding
import com.example.weather.network.API_KEY
import com.example.weather.network.WeatherApi
import com.example.weather.network.WeatherDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodayFragment : Fragment() {
    private var _binding: FragmentTodayBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    val TAG = "TodayFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val map = mutableMapOf<String, String>()
        map["q"] = "Malda"
        map["appid"] = API_KEY

        WeatherApi.retrofitService.getForecast(map).enqueue(object : Callback<WeatherDto> {
            override fun onResponse(
                call: Call<WeatherDto>,
                response: Response<WeatherDto>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
                val data = response.body()
                binding.tvWeather.text=data?.weather?.get(0)?.description
                binding.tvHumidity.text = "Humidity: ${data?.main?.humidity.toString()}"
                binding.tvPressure.text = "Pressure: ${data?.main?.pressure.toString()}"
                binding.tvTempMax.text =  "Max Temp: ${data?.main?.temp_max.toString()}"
                binding.tvTempMin.text =  "Min Temp: ${data?.main?.temp_min.toString()}"
                binding.tvWindSpeed.text = "Wind Speed: ${data?.wind?.speed.toString()}"
                binding.tvSunRise.text = "Sunrise: ${data?.sys?.sunrise.toString()}"
                binding.tvSunSet.text = "Sunset: ${data?.sys?.sunset.toString()}"
                _binding!!.tvLocation.text = data?.name
            }

            override fun onFailure(call: Call<WeatherDto>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}