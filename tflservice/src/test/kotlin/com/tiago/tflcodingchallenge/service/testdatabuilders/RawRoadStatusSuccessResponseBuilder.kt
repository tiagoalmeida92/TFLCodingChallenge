package com.tiago.tflcodingchallenge.service.testdatabuilders

import com.tiago.tflcodingchallenge.service.responses.RawRoadStatusSuccessResponse

class RawRoadStatusSuccessResponseBuilder private constructor() {
    companion object {

        const val DEFAULT_ID = "A1"
        const val DEFAULT_NAME = "A1"
        const val DEFAULT_STATUS_SEVERITY = "Unknown"
        const val DEFAULT_STATUS_SEVERITY_DESCRIPTION = "There is no information"

        @JvmStatic
        fun aRawRoadStatusSuccessResponse() = RawRoadStatusSuccessResponseBuilder()
    }

    fun build(): RawRoadStatusSuccessResponse {
        return RawRoadStatusSuccessResponse(id, name, statusSeverity, statusSeverityDescription)
    }

    private var id = DEFAULT_ID
    private var name = DEFAULT_NAME
    private var statusSeverity = DEFAULT_STATUS_SEVERITY
    private var statusSeverityDescription = DEFAULT_STATUS_SEVERITY_DESCRIPTION

    fun withId(id: String): RawRoadStatusSuccessResponseBuilder {
        this.id = id
        return this
    }

    fun withName(name: String): RawRoadStatusSuccessResponseBuilder {
        this.name = name
        return this
    }

    fun withStatusSeverity(statusSeverity: String): RawRoadStatusSuccessResponseBuilder {
        this.statusSeverity = statusSeverity
        return this
    }

    fun withStatusSeverityDescription(statusSeverityDescription: String): RawRoadStatusSuccessResponseBuilder {
        this.statusSeverityDescription = statusSeverityDescription
        return this
    }
}
