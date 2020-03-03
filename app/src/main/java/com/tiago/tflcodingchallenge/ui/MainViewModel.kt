package com.tiago.tflcodingchallenge.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tiago.usecases.tflcodingchallenge.dataaccess.FailureReason
import com.tiago.usecases.tflcodingchallenge.dataaccess.Status
import com.tiago.usecases.tflcodingchallenge.usecases.GetRoadStatus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getRoadStatus: GetRoadStatus
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val liveData: MutableLiveData<MainViewState> by lazy {
        MutableLiveData<MainViewState>()
    }

    fun submitSearchButtonClick(roadId: String) {
        //TODO do some validation
        compositeDisposable.add(getRoadStatus.getRoadStatus(roadId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { liveData.value = MainViewState.Loading }
            .subscribe(
                {
                    if (it.status == Status.SUCCESS) {
                        liveData.value = MainViewState.Data(it.roadStatus)
                    } else {
                        liveData.value = MainViewState.Error(it.failureReason)
                    }
                }, {
                    liveData.value = MainViewState.Error(FailureReason.NETWORK_ERROR)
                })
        )


    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
