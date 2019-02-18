package com.android.thedgmh.data

import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel
import io.reactivex.Observable
import io.reactivex.Single
import io.realm.Realm

/**
 * Created by mohamedsaleh on 2/18/19.
 */
class ProductsLocalDataSource : ProductsDataSource {

    override fun getProductsSavedCount(): Long {
        val realmObject = Realm.getDefaultInstance()
        realmObject.beginTransaction()
        val count = realmObject.where(ProductItemModel::class.java).count()
        realmObject.commitTransaction()
        return count
    }

    override fun getProducts(): Observable<ProductsModel>? {
        val realmObject = Realm.getDefaultInstance()
        realmObject.beginTransaction()
        var productsList = realmObject.where(ProductItemModel::class.java).findAll()
        realmObject.commitTransaction()
        val products = ProductsModel(productsList, productsList.size)
        return Observable.just(products)
    }

    override fun saveProductsItems(productsItems: List<ProductItemModel>) {
        val realmObject = Realm.getDefaultInstance()
        realmObject.beginTransaction()
        realmObject.insertOrUpdate(productsItems)
        realmObject.commitTransaction()
    }
}