package com.tiago.service

import com.tiago.tflcodingchallenge.service.RoadStatusApi

interface RoadStatusApiFactory {
    fun createForEndpoint(baseUrl: String): RoadStatusApi
}