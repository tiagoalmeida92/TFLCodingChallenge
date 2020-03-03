package com.tiago.usecases.tflcodingchallenge.dataaccess

import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusResponse
import io.reactivex.Single

interface RoadStatusDataSource {
    fun getRoadStatus(roadId: String) : Single<RoadStatusResponse>
}