package com.tiago.tflcodingchallenge.service

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSuccessResponse
import com.tiago.tflcodingchallenge.testdata.RoadStatusBuilder.Companion.aRoadStatus
import com.tiago.usecases.tflcodingchallenge.dataaccess.FailureReason
import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusResponse
import io.reactivex.Single
import java.io.IOException
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RoadStatusServiceImplTest {

    private val roadStatusApi: RoadStatusApi = mock()
    private val parser: RoadStatusResponseParser = mock()

    private lateinit var roadStatusServiceImpl: RoadStatusService

    @Before
    fun setUp() {
        roadStatusServiceImpl = RoadStatusService(roadStatusApi, parser)
    }

    @Test
    fun givenRequestSucceeds_whenFetchRoadStatus_thenSuccessIsReturned() {
        val roadId = "A1"
        val roadStatus = aRoadStatus().withId(roadId).build()
        val expectedResponse = RoadStatusResponse.createSuccess(roadStatus)
        val rawRoadStatusSuccessResponse = RawRoadStatusSuccessResponse(
            roadStatus.id,
            roadStatus.roadName,
            roadStatus.statusSeverity,
            roadStatus.statusSeverityDescription
        )

        given(roadStatusApi.roadStatus(any()))
            .willReturn(Single.just(Response.success(200, listOf(rawRoadStatusSuccessResponse))))
        given(parser.parse(any())).willReturn(expectedResponse)

        val response = roadStatusServiceImpl.getRoadStatus(roadId).blockingGet()

        verify(roadStatusApi).roadStatus(roadId)
        verify(parser).parse(any())
        assertEquals(expectedResponse, response)
    }

    @Test
    fun givenRequestReturns404_whenFetchRoadStatus_thenFailureNotFoundIsReturned() {
        val roadId = "A1"
        val expectedResponse = RoadStatusResponse.createFailure(
            FailureReason.ROAD_NOT_FOUND)

        given(roadStatusApi.roadStatus(any())).willReturn(
            Single.just(Response.error(404, ResponseBody.create(null, "")))
        )
        given(parser.parse(any())).willReturn(expectedResponse)

        val response = roadStatusServiceImpl.getRoadStatus(roadId).blockingGet()

        verify(roadStatusApi).roadStatus(roadId)
        verify(parser).parse(any())
        assertEquals(expectedResponse, response)
    }

    @Test
    fun givenRequestReturns500_whenFetchRoadStatus_thenFailureServerErrorIsReturned() {
        val roadId = "A1"
        val expectedResponse = RoadStatusResponse.createFailure(
            FailureReason.SERVER_ERROR)

        given(roadStatusApi.roadStatus(any())).willReturn(
            Single.just(Response.error(500, ResponseBody.create(null, "")))
        )
        given(parser.parse(any())).willReturn(expectedResponse)

        val response = roadStatusServiceImpl.getRoadStatus(roadId).blockingGet()

        verify(roadStatusApi).roadStatus(roadId)
        verify(parser).parse(any())
        assertEquals(expectedResponse, response)
    }

    @Test
    fun givenNetworkError_whenFetchRoadStatus_thenNetworkErrorReturned() {
        val roadId = "A1"

        given(roadStatusApi.roadStatus(any())).willReturn(
            Single.error(IOException()))

        val testSubscriber = roadStatusServiceImpl.getRoadStatus(roadId).test()

        verify(roadStatusApi).roadStatus(roadId)
        testSubscriber.assertError(IOException::class.java)
    }
}
