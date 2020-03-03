package com.tiago.tflcodingchallenge.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.tiago.tflcodingchallenge.testdata.RoadStatusBuilder.Companion.aRoadStatus
import com.tiago.tflcodingchallenge.ui.helpers.RxImmediateSchedulerRule
import com.tiago.usecases.tflcodingchallenge.dataaccess.FailureReason
import com.tiago.usecases.tflcodingchallenge.dataaccess.RoadStatusResponse
import com.tiago.usecases.tflcodingchallenge.usecases.GetRoadStatus
import io.reactivex.Single
import java.io.IOException
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val rxImmediateSchedulerRule = RxImmediateSchedulerRule()

    private val getRoadStatus: GetRoadStatus = mock()

    private val mainViewModel = MainViewModel(getRoadStatus)

    @Test
    fun whenRoadSubmitted_thenChangesToProgressStatus() {
        val roadId = "A1"

        given(getRoadStatus.getRoadStatus(roadId))
            .willReturn(Single.never())

        mainViewModel.submitSearchButtonClick(roadId)

        assertEquals(MainViewState.Loading, mainViewModel.liveData.value)
    }

    @Test
    fun givenRoadIdValid_whenRoadSubmitted_thenRoadStatusReturned() {
        val roadId = "A1"
        val roadStatus = aRoadStatus().withId(roadId).build()

        given(getRoadStatus.getRoadStatus(roadId))
            .willReturn(Single.just(RoadStatusResponse.createSuccess(roadStatus)))

        mainViewModel.submitSearchButtonClick(roadId)

        assertEquals(roadStatus, (mainViewModel.liveData.value as MainViewState.Data).roadStatus)
    }

    @Test
    fun givenRoadNotFound_whenRoadSubmitted_thenNotFoundErrorReturned() {
        val roadId = "A99"
        val expectedFailureReason = FailureReason.ROAD_NOT_FOUND

        given(getRoadStatus.getRoadStatus(roadId))
            .willReturn(Single.just(RoadStatusResponse.createFailure(expectedFailureReason)))

        mainViewModel.submitSearchButtonClick(roadId)

        assertEquals(MainViewState.Error(expectedFailureReason), mainViewModel.liveData.value)
    }

    @Test
    fun givenGetRoadReturnsException_whenRoadSubmitted_thenErrorReturned() {
        val roadId = "A1"

        given(getRoadStatus.getRoadStatus(roadId))
            .willReturn(Single.error(IOException()))

        mainViewModel.submitSearchButtonClick(roadId)

        assertEquals(MainViewState.Error(FailureReason.NETWORK_ERROR), mainViewModel.liveData.value)
    }
}