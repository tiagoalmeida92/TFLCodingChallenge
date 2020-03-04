package com.tiago.tflcodingchallenge

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class MainActivityTest : MotherTest() {

    @Test
    fun userSeesSearchBar() {
        given.user.launchesApp()

        then.user.seesSearchBar()
    }

    @Test
    fun userSeesRoadStatusAfterClick() {
        given.tflService.respondsWithGoodStatusRoad()
        given.user.launchesApp()

        `when`.user.onMainScreen().entersRoadName()
        `when`.user.onMainScreen().clicksFind()

        then.user.seesSearchBar()
        sleep(2000)
    }

}
