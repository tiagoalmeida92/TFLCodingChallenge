package com.tiago.tflcodingchallenge.bdd

import androidx.test.rule.ActivityTestRule
import com.tiago.tflcodingchallenge.bdd.arrangements.ServerRule
import com.tiago.tflcodingchallenge.bdd.arrangements.TflServiceArrangement
import com.tiago.tflcodingchallenge.bdd.arrangements.UserArrangement
import com.tiago.tflcodingchallenge.ui.MainActivity

class Given(
    activityRule: ActivityTestRule<MainActivity>,
    serverRule: ServerRule
) {
    val user = UserArrangement(activityRule)
    val tflService = TflServiceArrangement(serverRule)
}
