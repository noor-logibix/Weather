package com.example.weather.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

private const val BASE_URL = "https://api.openweathermap.org/"
const val API_KEY = "5f3219e74f1ae7d015c46e1e1d16acf3"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface WeatherApiService {
    @GET("data/2.5/weather")
    fun getForecast(@QueryMap options: Map<String, String>): WeatherDto
    //@Query("appid=5f3219e74f1ae7d015c46e1e1d16acf3")
    //fun getForecast(@Query("q") city: String): WeatherDto
}

object WeatherApi {
    val retrofitService : WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}

