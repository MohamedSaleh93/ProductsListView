package com.android.thedgmh.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by mohamedsaleh on 2/16/19.
 */

open class ProductsModel(
        @SerializedName("data")
        var productsData: List<ProductItemModel>,
        var count: Int = 0) {
}