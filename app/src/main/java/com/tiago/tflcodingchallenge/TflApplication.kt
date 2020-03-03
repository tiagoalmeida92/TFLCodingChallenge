package com.tiago.tflcodingchallenge

import android.app.Application
import com.tiago.tflcodingchallenge.di.DaggerApplicationComponent

class TflApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()

}
