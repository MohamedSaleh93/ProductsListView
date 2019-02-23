package com.android.thedgmh.injection.module

import com.android.thedgmh.data.network.ProductsApi
import com.android.thedgmh.utils.Constants
import com.android.thedgmh.utils.Constants.REQUEST_TIME_OUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by mohamedsaleh on 2/22/19.
 */
@Module class NetworkModule {


    @Provides
    @Singleton
    fun getProductsApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return  Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .client(initOkHttp())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    private fun initOkHttp():OkHttpClient {
        val httpClient = OkHttpClient().newBuilder().connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(httpLoggingInterceptor)

        return httpClient.build()
    }
}