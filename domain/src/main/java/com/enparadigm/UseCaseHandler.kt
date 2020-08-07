package com.enparadigm

import com.enparadigm.interactor.UseCase
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class UseCaseHandler @Inject constructor(){

    fun <REQ : UseCase.RequestValues, RES : UseCase.ResponseValue> execute(
        useCase: UseCase<REQ,RES>, values: REQ,singleObserver: DisposableSingleObserver<RES>
    ){
        useCase.requestValues = values
        useCase.execute(singleObserver)
    }
    fun <REQ : UseCase.RequestValues, RES : UseCase.ResponseValue> execute(
        useCase: UseCase<REQ, RES>,
        values: REQ,
        singleObserver: DisposableSingleObserver<RES>,
        scheduler: Scheduler
    ) {
        useCase.requestValues = values
        useCase.execute(singleObserver, scheduler)
    }
    companion object {

        private var INSTANCE: UseCaseHandler? = null

        val getInstance: UseCaseHandler
            get() {
                if (INSTANCE == null) {
                    INSTANCE = UseCaseHandler()
                }
                return INSTANCE!!
            }
    }
}