package com.tiago.tflcodingchallenge.bdd

import androidx.test.rule.ActivityTestRule
import com.tiago.tflcodingchallenge.bdd.arrangements.UserArrangement
import com.tiago.tflcodingchallenge.ui.MainActivity

class Given(
    activityRule: ActivityTestRule<MainActivity>
) {
    val user = UserArrangement(activityRule)
}
