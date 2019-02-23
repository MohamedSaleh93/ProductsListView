package com.android.thedgmh.data

import com.android.thedgmh.data.network.ProductsApi
import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsRemoteDataSource @Inject constructor(var productsApi: ProductsApi): ProductsDataSource {
    override fun saveProductsItems(productsItems: List<ProductItemModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProductsSavedCount(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * get the products from the internet
     */
    override fun getProducts(): Observable<ProductsModel>? {
        return productsApi.getProducts()
    }

}