package com.android.thedgmh.data

import com.android.thedgmh.data.network.ApiClient
import com.android.thedgmh.data.network.ProductsApi
import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel
import io.reactivex.Single

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsRemoteDataSource: ProductDataSource {
    override fun getProducts(): Single<ProductsModel> {
        return ApiClient.getClient().create(ProductsApi::class.java).getProducts()
    }

    override fun saveProductsItems(productsItems: List<ProductItemModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}