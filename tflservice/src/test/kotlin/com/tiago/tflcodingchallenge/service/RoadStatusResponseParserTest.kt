package com.tiago.tflcodingchallenge.service

import com.tiago.tflcodingchallenge.entities.RoadStatus
import com.tiago.tflcodingchallenge.entities.RoadStatusSeverity
import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusResponse
import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSeverity
import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSuccessResponse
import com.tiago.tflcodingchallenge.testdata.RoadStatusBuilder.Companion.aRoadStatus
import com.tiago.usecases.tflcodingchallenge.dataaccess.FailureReason
import com.tiago.usecases.tflcodingchallenge.dataaccess.Status
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test

class RoadStatusResponseParserTest {
    private val roadStatusResponseParser = RoadStatusResponseParser()

    @Test
    fun givenResponseIsSuccessful_whenParse_thenRoadStatusIsReturned() {
        val expectedRoadStatus = aRoadStatus()
            .withId("A1")
            .withName("A1")
            .withStatusSeverity(RoadStatusSeverity.Good)
            .withStatusSeverityDescription("Good")
            .build()
        val rawResponse = createSuccessfulResponse(expectedRoadStatus)

        val roadStatusResponse = roadStatusResponseParser.parse(rawResponse)

        assertEquals(Status.SUCCESS, roadStatusResponse.status)
        assertEquals(expectedRoadStatus, roadStatusResponse.roadStatus)
        assertNull(roadStatusResponse.failureReason)
    }

    @Test
    fun givenResponseIs404_whenParse_thenReturnsNotFound() {
        val rawResponse = createNotFoundResponse()

        val roadStatusResponse = roadStatusResponseParser.parse(rawResponse)

        assertEquals(Status.FAILURE, roadStatusResponse.status)
        assertEquals(FailureReason.ROAD_NOT_FOUND, roadStatusResponse.failureReason)
        assertNull(roadStatusResponse.roadStatus)
    }

    @Test
    fun givenResponseCodeIs500_whenParse_thenReturnsServerError() {
        val rawResponse = createServerErrorResponse()

        val roadStatusResponse = roadStatusResponseParser.parse(rawResponse)

        assertEquals(Status.FAILURE, roadStatusResponse.status)
        assertEquals(FailureReason.SERVER_ERROR, roadStatusResponse.failureReason)
        assertNull(roadStatusResponse.roadStatus)
    }

    private fun createNotFoundResponse(): RawRoadStatusResponse {
        return RawRoadStatusResponse(404, null)
    }

    private fun createServerErrorResponse(): RawRoadStatusResponse {
        return RawRoadStatusResponse(500, null)
    }

    private fun createSuccessfulResponse(roadStatus: RoadStatus): RawRoadStatusResponse {
        return RawRoadStatusResponse(200, listOf(
            RawRoadStatusSuccessResponse(
                roadStatus.id,
                roadStatus.roadName,
                RawRoadStatusSeverity.values()[roadStatus.statusSeverity.ordinal],
                roadStatus.statusSeverityDescription
            )
        ))
    }

}