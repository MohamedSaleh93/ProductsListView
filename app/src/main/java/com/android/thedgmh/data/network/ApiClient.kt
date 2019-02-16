package com.android.thedgmh.data.network

import com.android.thedgmh.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mohamedsaleh on 2/16/19.
 */
object ApiClient {

    private var retrofit: Retrofit? = null
    private const val REQUEST_TIME_OUT:Long = 60
    private var okHttpClient: OkHttpClient? = null

    fun getClient(): Retrofit {
        if (okHttpClient == null) {
            initOkHttp()
        }

        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return this.retrofit!!
    }

    private fun initOkHttp() {
        val httpClient = OkHttpClient().newBuilder().connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(httpLoggingInterceptor)

        okHttpClient = httpClient.build()
    }
}