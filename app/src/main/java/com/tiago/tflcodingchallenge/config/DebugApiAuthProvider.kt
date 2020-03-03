package com.tiago.tflcodingchallenge.config

import com.tiago.tflcodingchallenge.BuildConfig
import com.tiago.tflcodingchallenge.service.apiauth.ApiAuthProvider

class DebugApiAuthProvider :
    ApiAuthProvider {

    override fun getAppId(): String {
        return BuildConfig.TFL_SERVICE_APP_ID
    }

    override fun getAppKey(): String {
        return BuildConfig.TFL_SERVICE_APP_KEY
    }
}
