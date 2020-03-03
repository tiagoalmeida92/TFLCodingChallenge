package com.tiago.tflcodingchallenge.service.utils

import com.tiago.tflcodingchallenge.entities.RoadStatus
import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSuccessResponse

interface TflServiceDataConverter {
    fun convertToRoadStatus(rawRoadStatusSuccessResponse: RawRoadStatusSuccessResponse): RoadStatus
}