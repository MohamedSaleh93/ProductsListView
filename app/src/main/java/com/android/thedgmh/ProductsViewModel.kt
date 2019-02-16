package com.android.thedgmh

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.android.thedgmh.data.ProductsUserCase
import com.android.thedgmh.model.ProductItemModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsViewModel: ViewModel() {

    private val compositDisposable = CompositeDisposable()
    private val productsUserCase = ProductsUserCase(Schedulers.io(), AndroidSchedulers.mainThread())
    val productsItemsList = MutableLiveData<List<ProductItemModel>>()
    val loadingProductsError = MutableLiveData<String>()

    fun getProducts() {
        compositDisposable.add(productsUserCase.getProducts().subscribe({
            productsList ->
            productsItemsList.value = productsList.productsData
        }, {
            t ->  loadingProductsError.value = t.localizedMessage
        }))
    }
}