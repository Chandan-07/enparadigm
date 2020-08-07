package com.app.remote
import io.reactivex.Single

public interface ApiHandler {
  fun getWeatherList(cityName:String): Single<Response>
}