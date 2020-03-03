package com.tiago.tflcodingchallenge.bdd.assertions

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.tiago.tflcodingchallenge.R

class UserAssertions {

    fun seesSearchBar() {
        assertDisplayed(R.id.roadNameInput)
    }

}