package com.enparadigm.interactor

import com.enparadigm.executor.PostThreadExecutor
import com.enparadigm.executor.ThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<REQ : UseCase.RequestValues, RES : UseCase.ResponseValue> constructor(
    private val threadExecutor: ThreadExecutor,private val postThreadExecutor: PostThreadExecutor
){
private val disposables=  CompositeDisposable()
    protected abstract fun buildUseCaseObservable(requestValues: REQ? = null): Single<RES>
    open fun execute(singleObserver: DisposableSingleObserver<RES>) {
        val single = this.buildUseCaseObservable(requestValues).subscribeOn(
            Schedulers.from(threadExecutor)
        ).observeOn(postThreadExecutor.scheduler) as Single<RES>
        addDisposable(single.subscribeWith(singleObserver))
    }

    open fun execute(singleObserver: DisposableSingleObserver<RES>, scheduler: Scheduler) {
        val single = this.buildUseCaseObservable(requestValues).subscribeOn(
            Schedulers.from(threadExecutor)
        ).observeOn(postThreadExecutor.scheduler) as Single<RES>
        addDisposable(single.subscribeWith(singleObserver))
    }
    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
    var requestValues: REQ? = null

    var useCaseCallback: UseCaseCallback<RES>? = null

    internal fun run() {
        executeUseCase(requestValues)
    }

    open fun executeUseCase(requestValues: REQ?) {

    }
    /**
     * Data received from a request.
     */
    interface RequestValues
    interface ResponseValue

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)
        fun onError()
    }
}