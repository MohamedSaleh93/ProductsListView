package com.android.thedgmh.data

import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsUserCase(private val subscribeOnThread: Scheduler, private val observeOnThread: Scheduler) {

    private val productRemoteSource = ProductsRemoteDataSource()

    fun getProducts(): Single<ProductsModel> {
        return productRemoteSource.getProducts()
                .observeOn(observeOnThread)
                .subscribeOn(subscribeOnThread)
    }

    fun saveProductsItems(productsItems: List<ProductItemModel>) {
        // TODO be implemented after add the local storage implementation
    }
}