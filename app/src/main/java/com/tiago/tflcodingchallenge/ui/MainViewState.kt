package com.tiago.tflcodingchallenge.ui

import com.tiago.tflcodingchallenge.entities.RoadStatus
import com.tiago.usecases.tflcodingchallenge.dataaccess.FailureReason

sealed class MainViewState {
    object WaitingInput : MainViewState()
    object Loading : MainViewState()
    data class Error(val reason: FailureReason) : MainViewState()
    data class Data(val roadStatus: RoadStatus) : MainViewState()
}