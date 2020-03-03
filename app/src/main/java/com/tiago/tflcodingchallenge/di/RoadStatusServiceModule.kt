package com.tiago.tflcodingchallenge.di

import com.tiago.service.RoadStatusApiFactory
import com.tiago.tflcodingchallenge.BuildConfig
import com.tiago.tflcodingchallenge.service.RoadStatusApi
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
        roadStatusApiFactory: RoadStatusApiFactory
    ): RoadStatusApi {
        return roadStatusApiFactory.createForEndpoint(BuildConfig.TFL_SERVICE_BASE_URL) // TODO
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