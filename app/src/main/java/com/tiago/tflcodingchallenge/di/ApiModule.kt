package com.tiago.tflcodingchallenge.di

import com.tiago.tflcodingchallenge.config.ApiAuthProviderImpl
import dagger.Module
import dagger.Provides

@Module
class ApiModule {
    @Provides
    fun provideApiAuthProvider(): com.tiago.tflcodingchallenge.service.apiauth.ApiAuthProvider {
        return ApiAuthProviderImpl()
    }
}