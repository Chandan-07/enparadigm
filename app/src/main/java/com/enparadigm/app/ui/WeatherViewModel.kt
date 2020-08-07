package com.enparadigm.app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enparadigm.GetImageListUsecase
import com.enparadigm.UseCaseHandler
import com.enparadigm.model.ResponseRecord
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
private val useCaseHandler: UseCaseHandler,
private val ImageListUsecase: GetImageListUsecase
): ViewModel(){

private val mutableLiveData= MutableLiveData<ResponseRecord>()

fun getWeatherList(cityName:String) {

    val disposableSingleObserver=  object : DisposableSingleObserver<GetImageListUsecase.ResponseValues>(){
        override fun onSuccess(t: GetImageListUsecase.ResponseValues) {

            mutableLiveData.postValue(t.items)
        }

        override fun onError(e: Throwable) {

            mutableLiveData.postValue(null)
         }

    }
    useCaseHandler.execute(ImageListUsecase,GetImageListUsecase.RequestValues(cityName),disposableSingleObserver)
}

     fun subScribeWeather() : MutableLiveData<ResponseRecord>{
        return mutableLiveData
    }
}