package com.tiago.tflcodingchallenge

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : MotherTest() {

    @Test
    fun userSeesSearchBar() {
        given.user.launchesApp()

        then.user.seesSearchBar()
    }
}
