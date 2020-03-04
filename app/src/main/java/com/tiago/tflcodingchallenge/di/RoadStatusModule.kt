package com.tiago.tflcodingchallenge.di

import com.tiago.tflcodingchallenge.service.RoadStatusApi
import com.tiago.tflcodingchallenge.service.RoadStatusResponseParser
import com.tiago.tflcodingchallenge.service.RoadStatusService
import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusDataSource
import com.tiago.usecases.tflcodingchallenge.usecases.GetRoadStatus
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AppModule::class,
        RoadStatusServiceModule::class,
        ViewModelModule::class
    ]
)
object RoadStatusModule {

    @JvmStatic
    @Provides
    fun provideGetRoadStatus(roadStatusDataSource: RoadStatusDataSource): GetRoadStatus {
        return GetRoadStatus(roadStatusDataSource)
    }

    @JvmStatic
    @Provides
    fun provideRoadStatusDataSource(
        roadStatusApi: RoadStatusApi,
        parser: RoadStatusResponseParser
    ): RoadStatusDataSource {
        return RoadStatusService(roadStatusApi, parser)
    }
}
