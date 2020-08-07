package com.app.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class Response(
    @SerializedName("weather") @Expose val weather: ArrayList<Weather>,
    @SerializedName("visibility") @Expose val visibility:Long,
    @SerializedName("wind") @Expose val wind:Wind,
    @SerializedName("main") @Expose val main:Main
)
data class Weather(
    @SerializedName("main") @Expose  val main:String,
    @SerializedName("description") @Expose  val description:String
)
data class Wind(
    @SerializedName("speed") @Expose val speed:Double,
    @SerializedName("deg") @Expose  val deg:Double
)
data class Main(
    @SerializedName("temp") @Expose  val main:Double,
    @SerializedName("pressure") @Expose  val pressure:Double,
    @SerializedName("humidity") @Expose val humidity:Double
)