package com.enparadigm

import com.enparadigm.executor.PostThreadExecutor
import com.enparadigm.executor.ThreadExecutor
import com.enparadigm.interactor.UseCase
import com.enparadigm.model.ResponseRecord
import com.enparadigm.repository.Repository
import io.reactivex.Single
import javax.inject.Inject

 class GetImageListUsecase @Inject constructor(
    private val repository: Repository,
    threadExecutor: ThreadExecutor,
    postThreadExecutor: PostThreadExecutor
) : UseCase<GetImageListUsecase.RequestValues, GetImageListUsecase.ResponseValues>(
     threadExecutor,postThreadExecutor){
     override fun buildUseCaseObservable(requestValues: RequestValues?): Single<ResponseValues> {
         return repository.getWeatherList(requestValues!!.cityName)
     }


     data class RequestValues  constructor(val cityName: String = "") :
         UseCase.RequestValues

    data class ResponseValues(
        val items: ResponseRecord
    ): ResponseValue
}