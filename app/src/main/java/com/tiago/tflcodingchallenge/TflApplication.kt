package com.tiago.tflcodingchallenge

import android.app.Application
import com.tiago.tflcodingchallenge.di.AppModule
import com.tiago.tflcodingchallenge.di.ApplicationComponent
import com.tiago.tflcodingchallenge.di.DaggerApplicationComponent

open class TflApplication : Application() {

    lateinit var appComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    open val tflApiUrl = BuildConfig.TFL_SERVICE_BASE_URL
}
