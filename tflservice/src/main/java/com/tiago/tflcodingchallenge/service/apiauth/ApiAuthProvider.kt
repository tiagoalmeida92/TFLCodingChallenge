package com.tiago.tflcodingchallenge.service.apiauth

interface ApiAuthProvider {
    fun getAppId(): String
    fun getAppKey(): String
}