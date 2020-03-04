package com.tiago.tflcodingchallenge.di

import com.tiago.tflcodingchallenge.TflApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: TflApplication) {

    @Singleton
    @Provides
    fun providesApplication(): TflApplication {
        return application
    }
}
