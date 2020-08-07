package com.enparadigm.data

import com.app.remote.Main
import com.app.remote.Response
import com.app.remote.Weather
import com.enparadigm.model.MainRecord
import com.enparadigm.model.ResponseRecord
import com.enparadigm.model.WeatherRecord
import com.enparadigm.model.WindRecord
import javax.inject.Inject

open class Mapper @Inject constructor(){

fun convert(response: Response): ResponseRecord{
    return  ResponseRecord(convertWeather(response.weather),response.visibility,WindRecord(response.wind.speed,response.wind.deg),convertMain(response.main))
}

    private fun convertMain(data: Main): MainRecord {

        return  MainRecord(data.main,data.pressure,data.humidity)
    }  
    
    private fun convertWeather(data: ArrayList<Weather>): ArrayList<WeatherRecord> {

        val list = ArrayList<WeatherRecord>()
        for(item in data){
            list.add(WeatherRecord(item.main,item.description))
        }
        return  list
    }
}