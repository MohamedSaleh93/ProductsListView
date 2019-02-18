package com.android.thedgmh.data

import com.android.thedgmh.model.ProductsModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsUseCase(private val subscribeOnThread: Scheduler, private val observeOnThread: Scheduler) {

    private val productRemoteSource = ProductsRemoteDataSource()
    private val productLocalSource = ProductsLocalDataSource()

    fun getProducts(): Observable<ProductsModel>? {
        val count = productLocalSource.getProductsSavedCount()
        val localProducts = productLocalSource.getProducts()
                ?.subscribeOn(Schedulers.computation())

        val remoteProducts = productRemoteSource.getProducts()
                ?.doAfterNext {
                    it -> productLocalSource.saveProductsItems(it.productsData)
                }
                ?.subscribeOn(Schedulers.io())
        if (count == 0L)
            return remoteProducts

        return localProducts
    }
}