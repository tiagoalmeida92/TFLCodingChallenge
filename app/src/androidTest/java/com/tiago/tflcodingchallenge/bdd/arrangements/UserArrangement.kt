package com.tiago.tflcodingchallenge.bdd.arrangements

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.tiago.tflcodingchallenge.ui.MainActivity

class UserArrangement(
    private val activityTestRule: ActivityTestRule<MainActivity>
) {
    fun launchesApp() {
        activityTestRule.launchActivity(Intent())
    }
}
