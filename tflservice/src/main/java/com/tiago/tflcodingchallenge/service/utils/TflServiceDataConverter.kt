package com.tiago.tflcodingchallenge.service.utils

import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSuccessResponse
import com.tiago.tflcodingchallenge.entities.RoadStatus

interface TflServiceDataConverter {
    fun convertToRoadStatus(rawRoadStatusSuccessResponse: RawRoadStatusSuccessResponse): RoadStatus
}
