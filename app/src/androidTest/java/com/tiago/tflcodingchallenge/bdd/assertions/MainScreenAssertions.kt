package com.tiago.tflcodingchallenge.bdd.assertions

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.tiago.tflcodingchallenge.R
import com.tiago.tflcodingchallenge.bdd.arrangements.TestData


class MainScreenAssertions {
    fun seesSearchBar() {
        assertDisplayed(R.id.roadNameInput)
    }

    fun seesRoadStatus(){
        assertDisplayed(R.id.roadName, TestData.roadDisplayName)
        assertDisplayed(R.id.roadStatus, TestData.roadStatusSeverity)
        assertDisplayed(R.id.roadStatusDescription, TestData.roadStatusSeverityDescription)
    }

    fun seesNotFoundErrorMessage() {
        assertDisplayed(R.string.error_road_not_found)
    }

    fun seesServerErrorMessage() {
        assertDisplayed(R.string.error_server_down)
    }

    fun doesNotSeeRoadDetails() {
        assertNotDisplayed(TestData.roadDisplayName)
        assertNotDisplayed(TestData.roadStatusSeverity)
        assertNotDisplayed(TestData.roadStatusSeverityDescription)
    }

    fun seesEmptyInputError() {
        assertDisplayed(R.string.error_empty_input)
    }
}
