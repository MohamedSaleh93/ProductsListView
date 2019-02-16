package com.android.thedgmh.model

import com.google.gson.annotations.SerializedName

/**
 * Created by mohamedsaleh on 2/16/19.
 */
data class ProductsModel(
        @SerializedName("data")
        var productsData: List<ProductItemModel>,
        var count: Int) {
}