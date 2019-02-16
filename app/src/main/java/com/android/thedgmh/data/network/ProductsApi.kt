package com.android.thedgmh.data.network

import com.android.thedgmh.model.ProductsModel
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by mohamedsaleh on 2/16/19.
 */
interface ProductsApi {

    @GET("/")
    fun getProducts(): Single<ProductsModel>
}