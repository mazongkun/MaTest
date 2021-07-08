package com.example.ma.test.retrofit

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class OkhttpUtils {
    companion object {
        val JSON = "application/json; charset=utf-8".toMediaType()
        val okhttpClient = OkHttpClient()

        fun get(url: String): String? {
            val request = Request.Builder()
                .url(url)
                .build()

            val response = okhttpClient.newCall(request).execute()
            return response.body?.string()
        }

        fun post(url: String, json: String): String? {
            val body = json.toRequestBody(JSON)
            val request = Request.Builder()
                .url(url)
                .post(body)
                .build()

            val response = okhttpClient.newCall(request).execute()
            return response.body?.string()
        }
    }
}