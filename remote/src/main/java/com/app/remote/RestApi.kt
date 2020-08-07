package com.app.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.util.HashMap

interface RestApi {
  @GET("data/2.5/weather")
  fun getWeatherList(@QueryMap(encoded = true)  options:HashMap<String, String>): Single<Response>
}