package com.enparadigm.executor

import io.reactivex.Scheduler

interface PostThreadExecutor{
val scheduler: Scheduler
}