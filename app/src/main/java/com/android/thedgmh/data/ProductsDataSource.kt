package com.android.thedgmh.data

import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by mohamedsaleh on 2/16/19.
 */
interface ProductsDataSource {

    fun getProducts(): Observable<ProductsModel>?

    fun saveProductsItems(productsItems: List<ProductItemModel>)

    fun getProductsSavedCount(): Long
}