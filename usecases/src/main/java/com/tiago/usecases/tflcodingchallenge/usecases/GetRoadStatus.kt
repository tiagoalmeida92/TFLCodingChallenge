package com.tiago.usecases.tflcodingchallenge.usecases

import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusDataSource
import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusResponse
import io.reactivex.Single

open class GetRoadStatus(
    private val roadStatusDataSource: RoadStatusDataSource
) {
    open fun getRoadStatus(roadId: String): Single<RoadStatusResponse> {
        return roadStatusDataSource.getRoadStatus(roadId)
    }
}
