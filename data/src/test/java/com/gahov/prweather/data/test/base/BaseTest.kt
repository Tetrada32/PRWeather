package com.gahov.prweather.data.test.base

import com.gahov.prweather.data.test.base.file.FileReader
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import mockwebserver3.QueueDispatcher
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
abstract class BaseTest : BaseTestConfig {

    internal lateinit var mockWebServer: MockWebServer

    internal open var useMockServer: Boolean = true

    private lateinit var closable: AutoCloseable

    protected var fileReader: FileReader = FileReader()

    @Before
    override fun setUp() {
        closable = MockitoAnnotations.openMocks(this)
        initMockWebServer()
    }

    @After
    override fun tearDown() {
        if (useMockServer) {
            mockWebServer.shutdown()
        }
        closable.close()
    }

    internal fun setDefaultDispatcher() {
        mockWebServer.dispatcher = QueueDispatcher()
    }

    internal fun enqueueData(mockResponse: MockResponse) {
        if (useMockServer) {
            mockWebServer.enqueue(response = mockResponse)
        }
    }

    private fun initMockWebServer() {
        if (useMockServer) {
            mockWebServer = MockWebServer()
            mockWebServer.start()
        }
    }

    companion object {
        fun generateSuccessDefaultResponse(): MockResponse {
            return MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_NO_CONTENT)
            }
        }

        fun generateFailureDefaultResponse(): MockResponse {
            return MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
            }
        }

        fun generateSuccessResponse(jsonString: String): MockResponse {
            return MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json; charset=utf-8")
                setBody(jsonString)
            }
        }

        fun generateFailureResponse(
            body: String, error: Int = HttpURLConnection.HTTP_UNAUTHORIZED
        ): MockResponse {
            return MockResponse().apply {
                setResponseCode(error)
                addHeader("Content-Type", "application/json; charset=utf-8")
                setBody(body)
            }
        }
    }
}