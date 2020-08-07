package com.enparadigm.data.executor

import com.enparadigm.GetImageListUsecase
import com.enparadigm.data.Mapper
import com.enparadigm.repository.Repository
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val  dataSource: DataSource): Repository {

    val mapper = Mapper()
    override fun getWeatherList(cityName:String): Single<GetImageListUsecase.ResponseValues> {
        return dataSource.remote().handler().getWeatherList(cityName).flatMap {
            Single.just(GetImageListUsecase.ResponseValues(mapper.convert(it)))
        }
    }
}