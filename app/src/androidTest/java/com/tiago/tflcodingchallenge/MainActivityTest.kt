package com.tiago.tflcodingchallenge

import androidx.test.ext.junit.runners.AndroidJUnit4
import java.lang.Thread.sleep
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : MotherTest() {

    @Test
    fun userSeesSearchBar() {
        given.user.launchesApp()

        then.user.onMainScreen().seesSearchBar()
    }

    @Test
    fun userSeesErrorWhenSubmitEmptyId() {
        given.user.launchesApp()

        `when`.user.onMainScreen().clicksFind()

        then.user.onMainScreen().seesEmptyInputError()
    }

    @Test
    fun userSeesRoadStatusAfterClick() {
        given.tflService.respondsWithGoodStatusRoad()
        given.user.launchesApp()

        `when`.user.onMainScreen().entersRoadName()
        `when`.user.onMainScreen().clicksFind()

        then.user.onMainScreen().seesRoadStatus()
    }

    @Test
    fun userSeesErrorMessageWhenRoadNotFound() {
        given.tflService.respondsWithNotFound()
        given.user.launchesApp()

        `when`.user.onMainScreen().entersRoadName()
        `when`.user.onMainScreen().clicksFind()

        then.user.onMainScreen().seesNotFoundErrorMessage()
    }

    @Test
    fun userSeesErrorMessageWhenServerReturnsError() {
        given.tflService.respondsWithError()
        given.user.launchesApp()

        `when`.user.onMainScreen().entersRoadName()
        `when`.user.onMainScreen().clicksFind()

        then.user.onMainScreen().seesServerErrorMessage()
    }

    @Test
    fun userSeesPreviousResultClearedAfterError() {
        given.tflService.respondsWithGoodStatusRoad()
        given.tflService.respondsWithNotFound()
        given.user.launchesApp()

        `when`.user.onMainScreen().entersRoadName()
        `when`.user.onMainScreen().clicksFind()

        sleep(1000)
        `when`.user.onMainScreen().entersRoadName()
        `when`.user.onMainScreen().clicksFind()

        then.user.onMainScreen().doesNotSeeRoadDetails()
        then.user.onMainScreen().seesNotFoundErrorMessage()
    }
}
