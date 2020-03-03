package com.tiago.tflcodingchallenge.service

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.tiago.tflcodingchallenge.service.apiauth.ApiAuthProvider
import com.tiago.tflcodingchallenge.service.responses.ROAD_RESPONSE
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RoadStatusApiTest {

    private lateinit var mockServer: MockWebServer
    private lateinit var baseUrl: String

    private val appId: String = "APPID"
    private val appKey: String = "APPKEY"
    private lateinit var roadStatusApi: RoadStatusApi

    private val apiAuthProvider: ApiAuthProvider = mock()

    @Before
    fun setUp() {
        given(apiAuthProvider.getAppId()).willReturn(appId)
        given(apiAuthProvider.getAppKey()).willReturn(appKey)

        mockServer = MockWebServer()
        mockServer.start()
        baseUrl = mockServer.url("").toString()
        roadStatusApi = RoadStatusApiFactoryImpl(apiAuthProvider).createForEndpoint(baseUrl)
    }

    @After
    fun teardown() {
        mockServer.shutdown()
    }

    @Test
    fun whenFetchRoadStatus_thenRequestIsCorrect() {
        mockServer.enqueue(MockResponse().setBody(ROAD_RESPONSE).setResponseCode(200))

        val roadId = "A1"
        roadStatusApi
            .roadStatus(roadId)
            .test()
            .assertOf {
                val request = mockServer.takeRequest()
                assertEquals("GET", request.method)
                assertEquals("/Road/$roadId?app_id=$appId&app_key=$appKey", request.path)
            }
    }
}
