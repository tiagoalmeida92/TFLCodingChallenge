package com.tiago.tflcodingchallenge.service.responses

data class RawRoadStatusResponse(
    val code: Int,
    val body: List<RawRoadStatusSuccessResponse>?
)
