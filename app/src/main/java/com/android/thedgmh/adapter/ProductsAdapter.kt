package com.android.thedgmh.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.android.thedgmh.R
import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.model.ProductsModel

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsAdapter(val productsList: List<ProductItemModel>): RecyclerView.Adapter<ProductsViewHolder>() {

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(View.inflate(parent.context, R.layout.products_list_item, null))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bindProduct(productsList[position])
    }
}