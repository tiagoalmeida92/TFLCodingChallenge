package com.tiago.tflcodingchallenge.testdata

import com.tiago.tflcodingchallenge.entities.RoadStatus

class RoadStatusBuilder private constructor() {
    companion object {
        const val DEFAULT_ID = "A1"
        const val DEFAULT_NAME = "A1"
        const val DEFAULT_STATUS_SEVERITY = "Unknown"
        const val DEFAULT_STATUS_SEVERITY_DESCRIPTION = "Unknown"

        @JvmStatic
        fun aRoadStatus() = RoadStatusBuilder()
    }

    private var id = DEFAULT_ID
    private var name = DEFAULT_NAME
    private var statusSeverity = DEFAULT_STATUS_SEVERITY
    private var statusSeverityDescription = DEFAULT_STATUS_SEVERITY_DESCRIPTION

    fun withId(id: String): RoadStatusBuilder {
        this.id = id
        return this
    }

    fun withName(name: String): RoadStatusBuilder {
        this.name = name
        return this
    }

    fun withStatusSeverity(statusSeverity: String): RoadStatusBuilder {
        this.statusSeverity = statusSeverity
        return this
    }

    fun withStatusSeverityDescription(statusSeverityDescription: String): RoadStatusBuilder {
        this.statusSeverityDescription = statusSeverityDescription
        return this
    }

    fun build(): RoadStatus {
        return RoadStatus(id, name, statusSeverity, statusSeverityDescription)
    }
}
