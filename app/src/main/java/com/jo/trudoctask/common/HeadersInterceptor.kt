package com.jo.trudoctask.common

import com.jo.trudoctask.common.Constants.authToken
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Request Interceptor to add the headers (like token) to the request
 */
class HeadersInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(setupHeaders(chain.request()))
    }

    private fun setupHeaders(request: Request): Request {
        return request.newBuilder()
            .addHeader("Authorization", authToken)
            .build()
    }
}