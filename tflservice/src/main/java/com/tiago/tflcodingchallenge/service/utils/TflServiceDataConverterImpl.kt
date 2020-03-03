/*
package com.tiago.tflcodingchallenge.service.utils

import com.tiago.tflcodingchallenge.entities.RoadStatus
import com.tiago.tflcodingchallenge.entities.RoadStatusSeverity
import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSuccessResponse

class TflServiceDataConverterImpl : TflServiceDataConverter {
    override fun convertToRoadStatus(rawRoadStatusSuccessResponse: RawRoadStatusSuccessResponse): RoadStatus {
        return RoadStatus(
            rawRoadStatusSuccessResponse.id,
            rawRoadStatusSuccessResponse.displayName,
            RoadStatusSeverity.values()[rawRoadStatusSuccessResponse.statusSeverity.ordinal],
            rawRoadStatusSuccessResponse.statusSeverityDescription
        )
    }

}
*/
