package com.tiago.tflcodingchallenge.di

import com.tiago.tflcodingchallenge.TflApplication
import com.tiago.tflcodingchallenge.service.RoadStatusApi
import com.tiago.tflcodingchallenge.service.RoadStatusApiFactory
import com.tiago.tflcodingchallenge.service.RoadStatusApiFactoryImpl
import com.tiago.tflcodingchallenge.service.RoadStatusResponseParser
import com.tiago.tflcodingchallenge.service.apiauth.ApiAuthProvider
import dagger.Module
import dagger.Provides

@Module(
    includes = [ApiModule::class]
)
object RoadStatusServiceModule {

    @JvmStatic
    @Provides
    fun provideRoadStatusApi(
        tflApplication: TflApplication,
        roadStatusApiFactory: RoadStatusApiFactory
    ): RoadStatusApi {
        return roadStatusApiFactory.createForEndpoint(tflApplication.tflApiUrl)
    }

    @JvmStatic
    @Provides
    fun provideRoadStatusApiFactory(authProvider: ApiAuthProvider): RoadStatusApiFactory {
        return RoadStatusApiFactoryImpl(authProvider)
    }

    @JvmStatic
    @Provides
    fun provideParser(): RoadStatusResponseParser = RoadStatusResponseParser()
}
