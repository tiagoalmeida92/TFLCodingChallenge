package com.tiago.tflcodingchallenge.bdd.arrangements

object TestData {
    const val roadId = "a1"
    const val roadDisplayName = "a1"
    const val roadStatusSeverity = "Good"
    const val roadStatusSeverityDescription = "No Exceptional Delay"
}

val GOOD_ROAD_RESPONSE = """
[
  {
    "id": "${TestData.roadId}",
    "displayName": "${TestData.roadDisplayName}",
    "statusSeverity": "${TestData.roadStatusSeverity}",
    "statusSeverityDescription": "${TestData.roadStatusSeverityDescription}",
    "bounds": "[[-0.25616,51.5319],[-0.10234,51.6562]]",
    "envelope": "[[-0.25616,51.5319],[-0.25616,51.6562],[-0.10234,51.6562],[-0.10234,51.5319],[-0.25616,51.5319]]",
    "url": "/Road/a1"
  }
]
"""
