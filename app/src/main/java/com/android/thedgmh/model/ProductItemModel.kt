package com.android.thedgmh.model

/**
 * Created by mohamedsaleh on 2/16/19.
 */
data class ProductItemModel(
        var id: Int,
        var name: String,
        var productDescription: String,
        var image: ProductImageModel,
        var price: Double)