package com.tiago.tflcodingchallenge.di

import com.tiago.tflcodingchallenge.ui.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RoadStatusModule::class
    ]
)
interface ApplicationComponent {
    fun inject(activity: BaseActivity)
}
