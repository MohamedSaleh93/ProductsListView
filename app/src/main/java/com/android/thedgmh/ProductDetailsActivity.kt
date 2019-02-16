package com.android.thedgmh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.thedgmh.model.ProductItemModel
import com.android.thedgmh.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_details.*

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val productModel = intent.getParcelableExtra<ProductItemModel>(Constants.KEY_PRODUCT_DETAILS)
        bindView(productModel)
    }

    private fun bindView(productItemModel: ProductItemModel?) {
        productItemModel?.image.let {
            Picasso.get()
                    .load(it?.link)
                    .resize(it?.width!!, it.height)
                    .into(productDetailsIV)
        }
        productDetailsNameTV.text = productItemModel?.name
        productDetailsPriceTV.text = productItemModel?.price.toString()
        productDetailsDescriptionTV.text = productItemModel?.productDescription
    }
}