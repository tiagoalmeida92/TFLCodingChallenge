package com.tiago.tflcodingchallenge.entities

data class RoadStatus (
    val id: String,
    val roadName: String,
    val statusSeverity: RoadStatusSeverity,
    val statusSeverityDescription: String
)