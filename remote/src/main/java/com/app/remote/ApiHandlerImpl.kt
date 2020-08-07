package com.app.remote

import com.app.remote.ApiHandler
import com.app.remote.RestApi
import io.reactivex.Single

class ApiHandlerImpl(private val restApi: RestApi) : ApiHandler {
  override fun getWeatherList(cityName:String): Single<Response> {
    val map= HashMap<String,String>()
    map.put("q",cityName)
    map.put("appid","439d4b804bc8187953eb36d2a8c26a02")
    return restApi.getWeatherList(map)
  }
}