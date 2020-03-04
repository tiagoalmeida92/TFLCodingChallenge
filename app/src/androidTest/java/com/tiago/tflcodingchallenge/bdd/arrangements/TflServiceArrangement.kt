package com.tiago.tflcodingchallenge.bdd.arrangements

class TflServiceArrangement(private val serverRule: ServerRule) {

    fun respondsWithGoodStatusRoad() {
        serverRule.addResponse("/Road", 200, GOOD_ROAD_RESPONSE)
    }
}
