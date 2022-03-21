package com.example.assignmentlistview.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import java.io.IOException

internal class LoggingInterceptor : Interceptor {
    private fun bodyToString(request: Request): String? {
        return try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body!!.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "did not work"
        }
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val t1 = System.currentTimeMillis()
        Log.d(
            "OkHttp", java.lang.String.format(
                "Sending request %s \nrequest : %s",
                request.url, bodyToString(request)
            )
        )
        val response: Response = chain.proceed(request)
        val t2 = System.currentTimeMillis()
        Log.d(
            "OkHttp", String.format(
                "Received response for %s in %sms%n%s",
                response.request.url, t2 - t1, response.headers
            )
        )
        return response
    }
}