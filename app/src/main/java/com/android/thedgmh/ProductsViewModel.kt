package com.android.thedgmh

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.android.thedgmh.data.ProductsUseCase
import com.android.thedgmh.model.ProductItemModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by mohamedsaleh on 2/16/19.
 */
class ProductsViewModel: ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val productsUserCase = ProductsUseCase(Schedulers.io(), AndroidSchedulers.mainThread())
    val productsItemsList = MutableLiveData<List<ProductItemModel>>()
    val loadingProductsError = MutableLiveData<String>()

    fun getProducts() {
        productsUserCase.getProducts()?.subscribe({
            productsList ->
            productsItemsList.postValue(productsList.productsData)
        }, {
            t ->  loadingProductsError.value = t.localizedMessage
        })?.let { compositeDisposable.add(it) }
    }
}