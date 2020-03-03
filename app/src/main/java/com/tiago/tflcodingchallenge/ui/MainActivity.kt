package com.tiago.tflcodingchallenge.ui

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tiago.tflcodingchallenge.R
import com.tiago.tflcodingchallenge.databinding.ActivityMainBinding
import com.tiago.tflcodingchallenge.entities.RoadStatus
import com.tiago.usecases.tflcodingchallenge.dataaccess.FailureReason
import injector
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        observeViewModel()
    }

    private fun setupListeners() {
        binding.submitSearchBtn.setOnClickListener {
            val input = binding.roadNameInput.text
            mainViewModel.submitSearchButtonClick(input.toString())
        }
    }

    private fun observeViewModel() {
        mainViewModel.liveData.observe(this, Observer { state ->
            when (state) {
                // is MainViewState.WaitingInput -> showInitialState()
                is MainViewState.Error -> showError(state.reason)
                is MainViewState.Loading -> showLoading()
                is MainViewState.Data -> showRoadStatus(state.roadStatus)
            }
        })
    }

    private fun showRoadStatus(roadStatus: RoadStatus) {
        hideLoading()
        binding.roadDetails.visibility = VISIBLE
        binding.roadDetails.roadNameLabel.text = roadStatus.roadName
        binding.roadDetails.roadStatusLabel.text = roadStatus.statusSeverityDescription
    }

    private fun showError(reason: FailureReason) {
        hideLoading()
        val errorMessageId = when (reason) {
            FailureReason.ROAD_NOT_FOUND -> R.string.error_road_not_found
            FailureReason.SERVER_ERROR -> R.string.error_server_down
            FailureReason.NETWORK_ERROR -> R.string.error_network
            FailureReason.UNKNOWN -> R.string.error_unknown
        }

        Toast.makeText(this, errorMessageId, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        binding.progressView.visibility = VISIBLE
    }

    private fun hideLoading() {
        binding.progressView.visibility = GONE
    }
}