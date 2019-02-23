package com.android.thedgmh

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.android.thedgmh.data.UseCase
import com.android.thedgmh.model.ProductItemModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by mohamedsaleh on 2/16/19.
 *
 * View model class for getting products from the use case class and add it to the live data list
 * or return the error message
 */
class ProductsViewModel @Inject constructor(var productsUseCase: UseCase): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val productsItemsList = MutableLiveData<List<ProductItemModel>>()
    val loadingProductsError = MutableLiveData<String>()

    fun getProducts() {
        productsUseCase.getProducts()?.subscribe({
            productsList ->
            productsItemsList.postValue(productsList.productsData)
        }, {
            t ->  loadingProductsError.value = t.localizedMessage
        })?.let { compositeDisposable.add(it) }
    }
}