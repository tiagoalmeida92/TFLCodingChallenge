package com.tiago.tflcodingchallenge.service.responses

data class RawRoadStatusSuccessResponse (
    val id: String,
    val displayName: String,
    val statusSeverity: RawRoadStatusSeverity,
    val statusSeverityDescription: String
)