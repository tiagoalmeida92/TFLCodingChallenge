package com.tiago.tflcodingchallenge.service

import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSuccessResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RoadStatusApi {
    @GET("Road/{Id}")
    fun roadStatus(@Path("Id") id: String): Single<Response<List<RawRoadStatusSuccessResponse>>>
}
