package com.enparadigm.data.executor

import android.content.Context
import com.app.remote.RemoteSource
import com.app.remote.RemoteSourceImpl
import javax.inject.Inject

class DataSourceImpl @Inject constructor(context: Context) : DataSource{
  private var remote: RemoteSource = RemoteSourceImpl()
  override fun remote(): RemoteSource = remote

}