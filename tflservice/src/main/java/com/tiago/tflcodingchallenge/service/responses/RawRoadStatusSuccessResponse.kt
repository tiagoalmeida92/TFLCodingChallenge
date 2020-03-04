package com.tiago.tflcodingchallenge.service.responses

data class RawRoadStatusSuccessResponse(
    val id: String,
    val displayName: String,
    val statusSeverity: String,
    val statusSeverityDescription: String
)
