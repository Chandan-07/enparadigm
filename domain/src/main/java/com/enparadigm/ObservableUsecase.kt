package com.enparadigm

import com.enparadigm.interactor.UseCase
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

/**
 * Created by DK on 2019-05-31.
 */
interface ObservableUsecase<REQ : UseCase.RequestValues, RES : UseCase.ResponseValue> {
  fun execute(disposableObserver: DisposableObserver<RES>, requestValues: REQ): Observable<RES>
}