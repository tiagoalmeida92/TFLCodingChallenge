package com.tiago.tflcodingchallenge.service.apiauth

import com.tiago.tflcodingchallenge.service.apiauth.ApiAuthProvider
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val authProvider: ApiAuthProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()

        val url = originalUrl.newBuilder()
            .addQueryParameter("app_id", authProvider.getAppId())
            .addQueryParameter("app_key", authProvider.getAppKey())
            .build()

        val requestBuilder = originalRequest.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
