package com.tiago.tflcodingchallenge.service

import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusResponse
import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusResponse
import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusDataSource
import io.reactivex.Single

class RoadStatusService(
    private val roadStatusApi: RoadStatusApi,
    private val parser: RoadStatusResponseParser
): RoadStatusDataSource {

    override fun getRoadStatus(roadId: String): Single<RoadStatusResponse> {
        return roadStatusApi.roadStatus(roadId)
            .map { RawRoadStatusResponse(it.code(), it.body()) }
            .map { parser.parse(it) }
    }
}
