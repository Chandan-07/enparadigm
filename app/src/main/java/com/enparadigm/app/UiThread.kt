package com.enparadigm.app

import com.enparadigm.executor.PostThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

open class UiThread @Inject constructor() : PostThreadExecutor{
    override val scheduler: Scheduler= AndroidSchedulers.mainThread()
}