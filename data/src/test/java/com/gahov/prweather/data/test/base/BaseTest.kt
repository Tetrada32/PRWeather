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

/**
 * An abstract base test class configured for testing with Mockito and MockWebServer.
 */

@RunWith(MockitoJUnitRunner::class)
abstract class BaseTest : BaseTestConfig {

    internal lateinit var mockWebServer: MockWebServer

    internal open var useMockServer: Boolean = true

    private lateinit var closable: AutoCloseable

    protected var fileReader: FileReader = FileReader()

    /**
     * Sets up the test environment before each test case.
     */
    @Before
    override fun setUp() {
        closable = MockitoAnnotations.openMocks(this)
        initMockWebServer()
    }

    /**
     * Tears down the test environment after each test case.
     */
    @After
    override fun tearDown() {
        if (useMockServer) {
            mockWebServer.shutdown()
        }
        closable.close()
    }

    /**
     * Sets the default dispatcher for the mock web server.
     */
    internal fun setDefaultDispatcher() {
        mockWebServer.dispatcher = QueueDispatcher()
    }

    /**
     * Enqueues mock response data to the mock web server.
     *
     * @param mockResponse The mock response to be enqueued.
     */
    internal fun enqueueData(mockResponse: MockResponse) {
        if (useMockServer) {
            mockWebServer.enqueue(response = mockResponse)
        }
    }

    /**
     * Initializes the mock web server if the @useMockServer is true.
     */
    private fun initMockWebServer() {
        if (useMockServer) {
            mockWebServer = MockWebServer()
            mockWebServer.start()
        }
    }

    /**
     * Companion object containing utility functions for generating mock responses.
     */
    companion object {
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