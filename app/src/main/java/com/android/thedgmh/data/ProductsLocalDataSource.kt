package com.android.thedgmh.data

import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel
import io.reactivex.Observable
import io.realm.Realm

/**
 * Created by mohamedsaleh on 2/18/19.
 */
class ProductsLocalDataSource : ProductsDataSource {

    /**
     * return the count of products in the local database
     */
    override fun getProductsSavedCount(): Long {
        val realmObject = Realm.getDefaultInstance()
        realmObject.beginTransaction()
        val count = realmObject.where(ProductItemModel::class.java).count()
        realmObject.commitTransaction()
        return count
    }

    /**
     * get the products from the local database
     */
    override fun getProducts(): Observable<ProductsModel>? {
        val realmObject = Realm.getDefaultInstance()
        realmObject.beginTransaction()
        var productsList = realmObject.where(ProductItemModel::class.java).findAll()
        realmObject.commitTransaction()
        val products = ProductsModel(productsList, productsList.size)
        return Observable.just(products)
    }

    /**
     * save the products to the local database
     */
    override fun saveProductsItems(productsItems: List<ProductItemModel>) {
        val realmObject = Realm.getDefaultInstance()
        realmObject.beginTransaction()
        realmObject.insertOrUpdate(productsItems)
        realmObject.commitTransaction()
    }
}