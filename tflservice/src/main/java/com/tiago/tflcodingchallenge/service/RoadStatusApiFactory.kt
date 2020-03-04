package com.tiago.tflcodingchallenge.service

interface RoadStatusApiFactory {
    fun createForEndpoint(baseUrl: String): RoadStatusApi
}
