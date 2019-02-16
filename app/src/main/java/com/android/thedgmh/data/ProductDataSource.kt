package com.android.thedgmh.data

import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel
import io.reactivex.Single

/**
 * Created by mohamedsaleh on 2/16/19.
 */
interface ProductDataSource {

    fun getProducts(): Single<ProductsModel>

    fun saveProductsItems(productsItems: List<ProductItemModel>)
}