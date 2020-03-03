package com.tiago.tflcodingchallenge.service

import com.tiago.tflcodingchallenge.entities.RoadStatus
import com.tiago.tflcodingchallenge.entities.RoadStatusSeverity
import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusResponse
import com.tiago.usecases.tflcodingchallenge.dataaccess.FailureReason
import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusResponse

open class RoadStatusResponseParser {
    open fun parse(rawRoadStatusResponse: RawRoadStatusResponse): RoadStatusResponse {
        val code = rawRoadStatusResponse.code
        if(code == 200)
            return createSuccessResponse(rawRoadStatusResponse)
        return createFailedResponse(code)
    }

    private fun createSuccessResponse(rawRoadStatusResponse: RawRoadStatusResponse): RoadStatusResponse {
        val rawRoadStatus = rawRoadStatusResponse.body!![0]
        val roadStatus = RoadStatus(
            rawRoadStatus.id,
            rawRoadStatus.displayName,
            RoadStatusSeverity.values()[rawRoadStatus.statusSeverity.ordinal],
            rawRoadStatus.statusSeverityDescription
        )
        return RoadStatusResponse.createSuccess(roadStatus)
    }

    private fun createFailedResponse(code: Int): RoadStatusResponse {
        return RoadStatusResponse.createFailure(
            when(code){
                404 -> FailureReason.ROAD_NOT_FOUND
                500 -> FailureReason.SERVER_ERROR
                else -> FailureReason.UNKNOWN
            }
        )
    }
}