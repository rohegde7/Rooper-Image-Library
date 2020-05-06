package com.rohegde7.rooper.network.interceptor

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class CachingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request())

        val cacheControl = CacheControl.Builder()
            .maxAge(10, TimeUnit.DAYS)
            .build()

        return response.newBuilder()
            .header("Cache-Control", cacheControl.toString())
            .build()
    }
}