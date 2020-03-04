package com.tiago.tflcodingchallenge.config

import com.tiago.tflcodingchallenge.TflApplication
import com.tiago.tflcodingchallenge.bdd.arrangements.ServerRule

class TestApplication : TflApplication() {
    override val tflApiUrl: String
        get() = ServerRule.baseUrl
}
