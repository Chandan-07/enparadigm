package com.app.remote

import com.app.remote.ApiHandler

interface RemoteSource {
  fun handler(): ApiHandler
}