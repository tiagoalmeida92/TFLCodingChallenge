package com.tiago.usecases.tflcodingchallenge.dataaccess

import io.reactivex.Single

interface RoadStatusDataSource {
    fun getRoadStatus(roadId: String): Single<RoadStatusResponse>
}
