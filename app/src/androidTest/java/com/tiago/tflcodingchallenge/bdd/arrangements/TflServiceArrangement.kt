package com.tiago.tflcodingchallenge.bdd.arrangements

class TflServiceArrangement(private val serverRule: ServerRule) {

    companion object {
        private const val RoadStatusPath = "/Road"
    }

    fun respondsWithGoodStatusRoad() {
        serverRule.addResponse(RoadStatusPath, 200, GOOD_ROAD_RESPONSE)
    }

    fun respondsWithNotFound() {
        serverRule.addResponse(RoadStatusPath, 404, "")
    }

    fun respondsWithError() {
        serverRule.addResponse(RoadStatusPath, 500, "")
    }
}
