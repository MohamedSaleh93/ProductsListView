package com.android.thedgmh.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.android.thedgmh.model.ProductItemModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.products_list_item.view.*

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsViewHolder(var view: View): RecyclerView.ViewHolder(view) {

    fun bindProduct(productItemModel: ProductItemModel) {
        itemView.productNameTV.text = productItemModel.name
        itemView.productPriceTV.text = productItemModel.price.toString()
        Picasso.get()
                .load(productItemModel.image.link)
                .resize(productItemModel.image.width, productItemModel.image.height)
                .into(itemView.productImageIV)
    }
}