package com.enparadigm.model

data class ResponseRecord(
    val children: ArrayList<WeatherRecord>,
    val visibility:Long,
    val wind:WindRecord,
    val main:MainRecord
)
data class WeatherRecord(
    val main:String,
    val description:String
)
data class WindRecord(
     val speed:Double,
     val deg:Double
)
data class MainRecord(
     val main:Double,
     val pressure:Double,
     val humidity:Double
)