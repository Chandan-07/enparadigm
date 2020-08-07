package com.enparadigm.repository

import com.enparadigm.GetImageListUsecase
import io.reactivex.Single

interface Repository{
    fun getWeatherList(cityName:String) : Single<GetImageListUsecase.ResponseValues>
}