package com.enparadigm.data.executor
import com.app.remote.RemoteSource

interface DataSource{
    fun remote(): RemoteSource
}