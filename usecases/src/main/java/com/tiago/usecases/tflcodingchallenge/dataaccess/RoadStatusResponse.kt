package com.tiago.usecases.tflcodingchallenge.dataaccess

import com.tiago.tflcodingchallenge.entities.RoadStatus
import java.lang.IllegalStateException

class RoadStatusResponse private constructor(
    val status: Status,
    private val _roadStatus: RoadStatus? = null,
    private val _failureReason: FailureReason? = null
) {

    companion object {
        fun createSuccess(roadStatus: RoadStatus): RoadStatusResponse {
            return RoadStatusResponse(
                Status.SUCCESS,
                _roadStatus = roadStatus
            )
        }

        fun createFailure(failureReason: FailureReason?): RoadStatusResponse {
            return RoadStatusResponse(
                Status.FAILURE,
                _failureReason = failureReason
            )
        }
    }

    val roadStatus: RoadStatus
        get() {
            if (_roadStatus == null) {
                throw IllegalStateException("RoadStatus only accessible when status is SUCCESS")
            }
            return _roadStatus
        }

    val failureReason: FailureReason
        get() {
            if (_failureReason == null) {
                throw IllegalStateException("FailureReason only accessible when status is FAILURE")
            }
            return _failureReason
        }
}

enum class Status {
    SUCCESS,
    FAILURE
}

enum class FailureReason {
    ROAD_NOT_FOUND,
    SERVER_ERROR,
    NETWORK_ERROR,
    UNKNOWN
}