package com.tiago.tflcodingchallenge.bdd.arrangements

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.rules.ExternalResource

class ServerRule : ExternalResource() {

    companion object {
        const val port = 9999
        const val baseUrl = "http://localhost:$port"
    }

    private lateinit var server: MockWebServer

    fun addResponse(url: String, responseCode: Int, responseBody: String) {
        val response = MockResponse()
            .setResponseCode(responseCode)
            .setBody(responseBody)
        server.enqueue(response)
    }

    @Before
    override fun before() {
        server = MockWebServer()
        server.start(port)
    }

    @After
    override fun after() {
        server.shutdown()
    }

}
