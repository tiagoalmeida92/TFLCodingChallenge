package com.tiago.tflcodingchallenge.bdd.actions

import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import com.tiago.tflcodingchallenge.R

class MainScreenActions {
    fun entersRoadName() {
        writeTo(R.id.roadNameInput, "A road name")
    }

    fun clicksFind() {
        clickOn(R.id.submitSearchBtn)
    }
}
