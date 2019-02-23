package com.android.thedgmh.data

import com.android.thedgmh.model.ProductsModel
import io.reactivex.Observable

/**
 * Created by mohamedsaleh on 2/23/19.
 */
interface UseCase {

    fun getProducts(): Observable<ProductsModel>?
}