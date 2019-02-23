package com.android.thedgmh.data

import com.android.thedgmh.model.ProductsModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by mohamedsaleh on 2/16/19.
 *
 * Class that responsible for getting the products from the remote data source and local data source
 */
class ProductsUseCase @Inject constructor(val productRemoteSource: ProductsDataSource, val productLocalSource: ProductsDataSource): UseCase {

    /**
     * getting the products from the remote data source if there is no data in local
     * then save the data from web to the local and return from local
     */
    override fun getProducts(): Observable<ProductsModel>? {
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