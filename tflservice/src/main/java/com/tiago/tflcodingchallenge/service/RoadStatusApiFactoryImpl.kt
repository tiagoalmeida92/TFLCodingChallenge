package com.tiago.tflcodingchallenge.service

import com.tiago.service.RoadStatusApiFactory
import com.tiago.tflcodingchallenge.service.apiauth.ApiAuthProvider
import com.tiago.tflcodingchallenge.service.apiauth.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RoadStatusApiFactoryImpl(
    private val apiAuthProvider: ApiAuthProvider
) : RoadStatusApiFactory {

    override fun createForEndpoint(baseUrl: String): RoadStatusApi {
        val client = OkHttpClient()
            .newBuilder()
            .addInterceptor(
                AuthInterceptor(
                    apiAuthProvider
                )
            )
            .build()
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RoadStatusApi::class.java)
    }
}