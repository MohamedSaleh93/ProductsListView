package com.android.thedgmh.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.android.thedgmh.ProductDetailsActivity
import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.products_list_item.view.*

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindProduct(productItemModel: ProductItemModel) {
        itemView.productNameTV.text = productItemModel.name
        itemView.productPriceTV.text = productItemModel.price.toString()
        productItemModel.image?.width?.let {
            productItemModel.image?.height?.let { it1 ->
                Picasso.get()
                    .load(productItemModel.image?.link)
                    .resize(it, it1)
                    .into(itemView.productImageIV)
            }
        }
        itemView.itemCard.setOnClickListener {
            val intent = Intent(itemView.context, ProductDetailsActivity::class.java)
            intent.putExtra(Constants.KEY_PRODUCT_DETAILS, productItemModel)
            itemView.context.startActivity(intent)
        }
    }
}